package pvt.auna.solben.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pvt.auna.solben.model.api.*;
import pvt.auna.solben.model.api.response.ApiResponse;
import pvt.auna.solben.model.api.request.*;
import pvt.auna.solben.model.api.response.AuditResponse;
import pvt.auna.solben.model.api.response.SolbenActualizarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistraCartaGarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistrarResponse;
import pvt.auna.solben.model.bean.ClinicaBean;
import pvt.auna.solben.model.bean.DiagnosticoBean;
import pvt.auna.solben.model.bean.MedicoBean;
import pvt.auna.solben.model.bean.PacienteBean;
import pvt.auna.solben.service.*;
import pvt.auna.solben.util.AunaUtil;
import pvt.auna.solben.util.ConstanteUtil;
import pvt.auna.solben.util.SolbenException;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class SolbenController {

	private static final Logger LOG = LoggerFactory.getLogger(SolbenController.class);

	private static final String AFILIADO_NOT_FOUND = "2";
	private static final String ERROR_CAMPOS_OBLIGATORIO = "8";
	private static final String EXITOSO = "0";
    private static final String INTERNAL_SERVER_ERROR = "-2";


	private SolbenService solbenService;

	private OncoPacienteService pcteService;

	private OncoClinicaService clinService;

	private OncoDiagnosticoService diagService;

	private OncoMedicoService mediService;

	private AunaUtil aunaUtil;


	@Autowired
	public SolbenController(SolbenService solbenService, OncoPacienteService pcteService, OncoClinicaService clinService, OncoDiagnosticoService diagService, OncoMedicoService mediService, AunaUtil aunaUtil) {
		this.solbenService = solbenService;
		this.pcteService = pcteService;
		this.clinService = clinService;
		this.diagService = diagService;
		this.mediService = mediService;
		this.aunaUtil = aunaUtil;
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/registrar-scg",
				 produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
	             consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SolbenRegistrarResponse registrarSolPreliminarScg(@Validated
															@RequestBody SolicitudPreliminarRequest request,
															@RequestHeader HttpHeaders headers) {

		LOG.info("[SERVICIO: REGISTRAR SOLICITUD PRELIMINAR SGC][INICIO]");
		LOG.debug("[SERVICIO: REGISTRAR SOLICITUD PRELIMINAR SGC ][REQUEST][BODY][" + request.toString() + "]");
		SolbenRegistrarResponse response = new SolbenRegistrarResponse();
		HeaderBean header=new HeaderBean();
		try {
			//validación de campos
			header= aunaUtil.validHeader(headers);
			ApiResponse res;
			AuditResponse auditResponse;
			res = validarOncoClinica(request, headers);
			if (!res.getStatus().equalsIgnoreCase(EXITOSO)) {
				LOG.info("validarOncoClinica");
				auditResponse = mapAuditResponse(header, res);
				response.setAuditResponse(auditResponse);
				response.setRegistroSolPreliminar(null);
				return response;
			}
			res = validarOncoPaciente(request, headers);
			if (!res.getStatus().equalsIgnoreCase(EXITOSO)) {
				LOG.info("validarOncoPaciente");
				auditResponse = mapAuditResponse(header, res);
				response.setAuditResponse(auditResponse);
				response.setRegistroSolPreliminar(null);
				return response;
			}

			res = validarOncoDiagnostico(request, headers);
			if (!res.getStatus().equalsIgnoreCase(EXITOSO)) {
				LOG.info("validarOncoDiagnostico");
				auditResponse = mapAuditResponse(header, res);
				response.setAuditResponse(auditResponse);
				response.setRegistroSolPreliminar(null);
				return response;
			}

			res = validarOncoMedico(request, headers);
			if (!res.getStatus().equalsIgnoreCase(EXITOSO)) {
				LOG.info("validarOncoMedico");
				auditResponse = mapAuditResponse(header, res);
				response.setAuditResponse(auditResponse);
				response.setRegistroSolPreliminar(null);
				return response;
			}

			response = solbenService.registrarSolPreliminar(request, header);
			
		}catch (SolbenException e){
			LOG.error("[SERVICIO: REGISTRAR SOLICITUD PRELIMINAR SGC][ERROR]",e);
			AuditResponse auditResponse=new AuditResponse();
			auditResponse.setCodigoRespuesta(e.getCodResponse());
			auditResponse.setMensajeRespuesta(e.getMessage());

			if(Optional.ofNullable(header).isPresent()){
				auditResponse.setIdTransaccion(header.getIdTransaccion());
				auditResponse.setFechaTransaccion(header.getFechaTransaccion());
			}
			response.setAuditResponse(auditResponse);
			response.setRegistroSolPreliminar(null);

		}catch (Exception e){
			LOG.error("[SERVICIO: REGISTRAR SOLICITUD PRELIMINAR SGC][ERROR]",e);
			AuditResponse auditResponse = generarInternalServerError(header);
			response.setAuditResponse(auditResponse);
			response.setRegistroSolPreliminar(null);

		}

		return response;
	}

	private AuditResponse mapAuditResponse(HeaderBean header, ApiResponse res) {
		AuditResponse auditResponse;
		auditResponse=new AuditResponse();
		auditResponse.setFechaTransaccion(header.getFechaTransaccion());
		auditResponse.setIdTransaccion(header.getIdTransaccion());
		auditResponse.setMensajeRespuesta(res.getMessage());
		auditResponse.setCodigoRespuesta(res.getStatus());
		return auditResponse;
	}

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/actualizar-scg",
				 produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SolbenActualizarResponse actualizarSolben(@RequestBody ActualizarSolPrelimRequest request,
													 @RequestHeader HttpHeaders headers){

		LOG.info("[SERVICIO: ACTUALIZAR SCG ][INICIO]");
		LOG.debug("[SERVICIO: ACTUALIZAR SCG][REQUEST][BODY][" + request.toString() + "]");
		HeaderBean header=new HeaderBean();
		SolbenActualizarResponse response=new SolbenActualizarResponse();
		try {
			header= aunaUtil.validHeader(headers);
			response = solbenService.actualizarSolben(request,header);
		}catch (Exception e){
			LOG.error("[SERVICIO: ACTUALIZAR SCG ][ERROR]",e);
			AuditResponse auditResponse = generarInternalServerError(header);
			response.setAuditResponse(auditResponse);
			response.setActualizacionSCG(null);

		}
	    return response;
	}

	private AuditResponse generarInternalServerError(HeaderBean header) {
		AuditResponse auditResponse = new AuditResponse();
		auditResponse.setCodigoRespuesta(INTERNAL_SERVER_ERROR);
		auditResponse.setMensajeRespuesta("Error interno del Servidor");

		if (Optional.ofNullable(header).isPresent()) {
			auditResponse.setIdTransaccion(header.getIdTransaccion());
			auditResponse.setFechaTransaccion(header.getFechaTransaccion());
		}
		return auditResponse;
	}

	private ApiResponse validarOncoPaciente(SolicitudPreliminarRequest request, HttpHeaders headers) {
		ApiResponse api = new ApiResponse();
		PacienteRequest pcteRequest = new PacienteRequest();

		if (request.getCodAfiPaciente() == null || request.getCodAfiPaciente().trim().equalsIgnoreCase("")) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", " codAfiPaciente es requerido"));
			api.setResponse(null);
			return api;
		}

		pcteRequest.setIni(ConstanteUtil.INDICE_PAGINACION);
		pcteRequest.setFin(ConstanteUtil.SIZE_PAGINACION);
		pcteRequest.setTipoBus(ConstanteUtil.TIPO_CODIGO_AFILIADO);
		pcteRequest.setCodafir(request.getCodAfiPaciente());
	


		try {
			WsResponse response = pcteService.obtenerPaciente(pcteRequest, headers);
			PacienteBean pcte = (PacienteBean) response.getData();

			if (response != null && Integer.parseInt(response.getAudiResponse().getCodigoRespuesta()) >= 0) {
				if (response.getAudiResponse().getCodigoRespuesta().equals(EXITOSO)) {
					api.setStatus(ConstanteUtil.CODIGO_EXITOSO);
					api.setMessage(ConstanteUtil.MENSAJE_EXITOSO);
					api.setResponse(pcte);
				} else if(response.getAudiResponse().getCodigoRespuesta().equals(AFILIADO_NOT_FOUND)) {
					api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
					api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", " codAfiPaciente " + pcteRequest.getCodafir() + " no existe en Oncosys"));
					LOG.error(response.getAudiResponse().getMensajeRespuesta());
					api.setResponse(null);
				}
			} else {
				api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
				api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "ObtieneAfiliadoPaciente"));
				LOG.error(response.getAudiResponse().getMensajeRespuesta());
				api.setResponse(null);
			}

		} catch (Exception e) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "ObtieneAfiliadoPaciente," + e.toString()));
			api.setResponse(null);
			LOG.error(e.getMessage());
		}

		return api;
	}

	private ApiResponse validarOncoDiagnostico(SolicitudPreliminarRequest request, HttpHeaders headers) {
		ApiResponse api = new ApiResponse();
		DiagnosticoRequest diagRequest = new DiagnosticoRequest();

		if (request.getCodDiagnostico() == null || request.getCodDiagnostico().trim().equalsIgnoreCase("")) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", " codDiagnostico es requerido"));
			api.setResponse(null);
			return api;
		}

		diagRequest.setTipoBusqueda(ConstanteUtil.tipoXCod);
		diagRequest.setRegistroInicio(ConstanteUtil.registroIni);
		diagRequest.setRegistroFin(ConstanteUtil.registroIni);
		diagRequest.setCodigoDiagnostico(request.getCodDiagnostico());
		diagRequest.setNombreDiagnostico("");

		try {
			WsResponse response = diagService.obtenerDiagnostico(headers, diagRequest);
			if (response != null && Integer.parseInt(response.getAudiResponse().getCodigoRespuesta()) >= 0) {
				DiagnosticoBean diagnostico = (DiagnosticoBean) response.getData();
				if (response.getAudiResponse().getCodigoRespuesta().equals("0")) {
					
					if (diagnostico.getGrupo() != null && diagnostico.getGrupo().getCodigo() != null
							&& !diagnostico.getGrupo().getCodigo().equals("")) {
						api.setStatus(ConstanteUtil.CODIGO_EXITOSO);
						api.setMessage(ConstanteUtil.MENSAJE_EXITOSO);
						api.setResponse(null);
					} else {
						api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
						api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "Código de diagnostico " .concat(request.getCodDiagnostico())
								.concat(" no se encuentra registrado en Oncosys."))
								);
						api.setResponse(null);
					}
				} else if(response.getAudiResponse().getCodigoRespuesta().equals("2")) {
					api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
					//api.setStatus(response.getAudiResponse().getCodigoRespuesta());
					api.setMessage("Código de diagnóstico no registrado.");
					api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "codDiagnostico "+ diagRequest.getCodigoDiagnostico() +" no existe"));
					LOG.error(response.getAudiResponse().getMensajeRespuesta());
					api.setResponse(null);
				}
			} else {
				api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
				api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "listaDiagnostico"));
				LOG.error(response.getAudiResponse().getMensajeRespuesta());
				api.setResponse(null);
			}
		} catch (Exception e) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "listaDiagnostico " + e.toString()));
			api.setResponse(null);
		}

		return api;
	}

	private ApiResponse validarOncoMedico(SolicitudPreliminarRequest request, HttpHeaders headers) {
		ApiResponse api = new ApiResponse();
		MedicoRequest medicoRequest = new MedicoRequest();

		if (request.getCmpMedico() == null || request.getCmpMedico().trim().equalsIgnoreCase("")) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "cmpMedico es requerido"));
			api.setResponse(null);
			return api;
		}

		medicoRequest.setIni(ConstanteUtil.registroIni);
		medicoRequest.setFin(ConstanteUtil.registroIni);
		medicoRequest.setTipo(ConstanteUtil.tipoCmp);
		medicoRequest.setCodigoMed("");
		medicoRequest.setApellidoPat("");
		medicoRequest.setApellidoMat("");
		medicoRequest.setNombres("");
		medicoRequest.setCodcmp(request.getCmpMedico());
		medicoRequest.setTotal("");

		try {
			WsResponse response = mediService.obtenerMedicoTratante(headers, medicoRequest);
			MedicoBean medico = (MedicoBean) response.getData();
			if (medico != null) {
				api.setStatus(ConstanteUtil.CODIGO_EXITOSO);
				api.setMessage(ConstanteUtil.MENSAJE_EXITOSO);
				api.setResponse(null);
			} else {
				api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
				api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "cmpMedico '"+ medicoRequest.getCodcmp()  +"' no existe") );
				api.setResponse(null);
			}
		} catch (Exception e) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "listaMedicoTratante " + e.toString()));
			api.setResponse(null);
		}

		return api;
	}
	
	//validar codigo de clinica con el servicio de oncosys listaClinicas
	private ApiResponse validarOncoClinica(SolicitudPreliminarRequest request, HttpHeaders headers) {
		ApiResponse api = new ApiResponse();
		ClinicaRequest clinicaRequest = new ClinicaRequest();

		if (request.getCodClinica() == null || request.getCodClinica().trim().equalsIgnoreCase("")) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "codClinica requerido"));
			api.setResponse(null);
			return api;
		}

		clinicaRequest.setIni(ConstanteUtil.registroIni);
		clinicaRequest.setFin(ConstanteUtil.registroFinClinicas);
		clinicaRequest.setTipoBus(ConstanteUtil.tipoXCod);
		clinicaRequest.setCodcli(request.getCodClinica());
		clinicaRequest.setNomcli("''");

		try {
			WsResponse response = clinService.obtenerClinica(clinicaRequest, headers);
			ClinicaBean clinica = (ClinicaBean) response.getData();

			if (response != null && Integer.parseInt(response.getAudiResponse().getCodigoRespuesta()) >= 0) {
				if (response.getAudiResponse().getCodigoRespuesta().equals("0")) {
					api.setStatus(ConstanteUtil.CODIGO_EXITOSO);
					api.setMessage(ConstanteUtil.MENSAJE_EXITOSO);
					api.setResponse(clinica);
				} else if (Integer.parseInt(response.getAudiResponse().getCodigoRespuesta()) == 2){
					api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
					api.setMessage(ConstanteUtil.MENSAJE_ERROR_VALIDACION_DATO.replace("[field]", "clínica" + clinicaRequest.getCodcli() + " no existe en Oncosys"));
					api.setResponse(null);
				}else {
					api.setStatus(ConstanteUtil.CODIGO_ERROR_VALIDACION_DATO);
					api.setMessage(response.getAudiResponse().getMensajeRespuesta());
					api.setResponse(null);
				}
			} else {
				
				api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
				api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "Servicio ListaClinicas"));
				api.setResponse(null);
			}
		} catch (Exception e) {
			api.setStatus(ConstanteUtil.CODIGO_ERROR_INTERNO);
			api.setMessage(ConstanteUtil.MENSAJE_ERROR_INTERNO.replace("[componente]", "Servicio ListaClinicas") + e.toString());
			api.setResponse(null);
		}

		return api;
	}


	@CrossOrigin(origins = "*")
	@PostMapping(value = "/registrar-carga-scg",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
				consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SolbenRegistraCartaGarResponse registrarListaCartaGarantiaSolben(@RequestBody RegistrarCartaGarantiaRequest request,
													 @RequestHeader HttpHeaders headers){

		LOG.info("[SERVICIO: REGISTRAR  CARGA SCG][INICIO]");
		LOG.debug("[SERVICIO: REGISTRAR  CARGA SCG][REQUEST][BODY][" + request.toString() + "]");
		HeaderBean header=new HeaderBean();
		SolbenRegistraCartaGarResponse response=new SolbenRegistraCartaGarResponse();
		try {
			header= aunaUtil.validHeader(headers);
			response=solbenService.registrarListaCartaGarantiaSolben(request,header);
		}catch (Exception e){
			LOG.error("[SERVICIO: REGISTRAR  CARGA SCG][ERROR]",e);
			AuditResponse auditResponse = generarInternalServerError(header);
			response.setAuditResponse(auditResponse);
			//response.setActualizacionSCG(null);

		}
		return response;
	}
}
