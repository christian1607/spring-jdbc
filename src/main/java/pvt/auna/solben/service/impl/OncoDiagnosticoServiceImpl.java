package pvt.auna.solben.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pvt.auna.solben.config.OncoPropiedades;
import pvt.auna.solben.model.api.response.AudiResponse;
import pvt.auna.solben.model.api.request.GrupoDiagnosticoRequest;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.DiagnosticoRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;
import pvt.auna.solben.model.bean.DiagnosticoBean;
import pvt.auna.solben.model.bean.GrupoDiagnosticoBean;
import pvt.auna.solben.service.OncoDiagnosticoService;
import pvt.auna.solben.util.ConstanteUtil;
import pvt.auna.solben.util.GenericUtil;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OncoDiagnosticoServiceImpl implements OncoDiagnosticoService {

	private static final Logger log = LoggerFactory.getLogger(OncoDiagnosticoServiceImpl.class);

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private OncoPropiedades propiedades;

	String urlListaDiag;
	String urlListaGrpDiag;

	@Override
	public ResponseOnc getListarDiagnostico(HttpHeaders headers) throws Exception {

		ArrayList<DiagnosticoBean> listaDiagnostico = null;
		ResponseOnc response = null;

		urlListaDiag = propiedades.getOncoDiagnostico() + "/consulta/diagnostico";

		DiagnosticoRequest request = new DiagnosticoRequest();
		request.setTipoBusqueda(ConstanteUtil.tipoTodos);
		request.setCodigoDiagnostico("");
		request.setNombreDiagnostico("");
		request.setRegistroInicio(ConstanteUtil.registroIni);
		request.setRegistroFin(ConstanteUtil.registroFinDiagnostico);

		try {
			HttpEntity<DiagnosticoRequest> rqDiag = new HttpEntity<DiagnosticoRequest>(request, headers);
			response = restTemplate.postForObject(urlListaDiag, rqDiag, ResponseOnc.class);

			if (response != null && response.getAudiResponse() != null) {
				AudiResponse audi = response.getAudiResponse();
				if (audi.getCodigoRespuesta().equalsIgnoreCase("0")) {
					listaDiagnostico = new ArrayList<DiagnosticoBean>();
					for (int i = 0; i < response.getDataList().size(); i++) {
						HashMap<?, ?> diagResponse = (HashMap<?, ?>) response.getDataList().get(i);

						DiagnosticoBean objDiag = new DiagnosticoBean();
						objDiag.setCodigo((String) diagResponse.get("coddia"));
						objDiag.setDiagnostico((String) diagResponse.get("nomdia"));
						objDiag.setRn((Integer) diagResponse.get("rn"));

						GrupoDiagnosticoBean objGrupo = new GrupoDiagnosticoBean();
						objGrupo.setCodigo((String) diagResponse.get("codgru"));
						objGrupo.setDescripcion((String) diagResponse.get("nomgru"));
						objGrupo.setRn((Integer) diagResponse.get("rn"));

						objDiag.setGrupo(objGrupo);

						listaDiagnostico.add(objDiag);
					}

					response.setDataList(listaDiagnostico);
				} else {
					log.error(".getListarDiagnostico: " + audi.getMensajeRespuesta());
				}
			} else {
				log.error(".getListarDiagnostico: Error en el Servidor Oncosys diagnóstico.");
				response = GenericUtil.responseErrorList("Error en el Servidor Oncosys diagnóstico.");
			}

		} catch (Exception e) {
			log.error(".getListarGrupoDiagnostico: " + e.getMessage());
			response = GenericUtil.responseErrorList(e.getMessage());
		}

		return response;
	}

	@Override
	public WsResponse obtenerDiagnostico(HttpHeaders headers, DiagnosticoRequest request) throws Exception {

		DiagnosticoBean diagnostico = null;
		ResponseOnc diagnosticoResponse = null;
		WsResponse response = new WsResponse();

		urlListaDiag = propiedades.getOncoDiagnostico() + "/consulta/diagnostico";

		try {
			HttpEntity<DiagnosticoRequest> rqDiag = new HttpEntity<DiagnosticoRequest>(request, headers);
			diagnosticoResponse = restTemplate.postForObject(urlListaDiag, rqDiag, ResponseOnc.class);

			if (response != null && diagnosticoResponse.getAudiResponse() != null) {
				AudiResponse audi = diagnosticoResponse.getAudiResponse();

				if (audi.getCodigoRespuesta().equalsIgnoreCase("0")) {
					if (diagnosticoResponse.getDataList() != null && diagnosticoResponse.getDataList().size() == 1) {
						HashMap<?, ?> diagResponse = (HashMap<?, ?>) diagnosticoResponse.getDataList().get(0);

						diagnostico = new DiagnosticoBean();
						diagnostico.setCodigo((String) diagResponse.get("coddia"));
						diagnostico.setDiagnostico((String) diagResponse.get("nomdia"));
						diagnostico.setRn((Integer) diagResponse.get("rn"));

						GrupoDiagnosticoBean objGrupo = new GrupoDiagnosticoBean();
						objGrupo.setCodigo((String) diagResponse.get("codgru"));
						objGrupo.setDescripcion((String) diagResponse.get("nomgru"));
						objGrupo.setRn((Integer) diagResponse.get("rn"));

						diagnostico.setGrupo(objGrupo);
						
						response.setAudiResponse(audi);
						response.setData(diagnostico);
					} else {
						audi = GenericUtil.obtenerResponse(audi, "2", "Se encontraron más de un resultado.");
						response.setAudiResponse(audi);
						log.error(".obtenerDiagnostico: " + audi.getMensajeRespuesta());
					}
				} else {
					response.setAudiResponse(audi);
					log.error(".obtenerDiagnostico: " + audi.getMensajeRespuesta());
				}
			} else {
				response = GenericUtil.responseErrorData("Error e Servidor Oncosys Diagnostico");
			}

		} catch (Exception e) {
			log.error(this.getClass().getName() + ".obtenerDiagnostico: " + e.getMessage());
			response = GenericUtil.responseErrorData(e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseOnc getListarGrupoDiagnostico(HttpHeaders headers) throws Exception {
		ArrayList<GrupoDiagnosticoBean> listaGrupoDiagnostico = null;
		ResponseOnc grpDiagResponse = null;

		urlListaGrpDiag = propiedades.getOncoDiagnostico() + "/consulta/grupodiagnostico";

		GrupoDiagnosticoRequest request = new GrupoDiagnosticoRequest();
		request.setTipoBusqueda(ConstanteUtil.tipoTodos);
		request.setCodigoGrupoDiagnostico("");
		request.setNombreGrupoDiagnostico("");
		request.setRegistroInicio(ConstanteUtil.registroIni);
		request.setRegistroFin(ConstanteUtil.registroFinGrupoDiag);

		try {
			HttpEntity<GrupoDiagnosticoRequest> rqDiag = new HttpEntity<GrupoDiagnosticoRequest>(request, headers);
			grpDiagResponse = restTemplate.postForObject(urlListaGrpDiag, rqDiag, ResponseOnc.class);

			if (grpDiagResponse != null && grpDiagResponse.getAudiResponse() != null) {
				AudiResponse audi = grpDiagResponse.getAudiResponse();

				if (audi.getCodigoRespuesta().equalsIgnoreCase("0")) {
					listaGrupoDiagnostico = new ArrayList<GrupoDiagnosticoBean>();
					for (int i = 0; i < grpDiagResponse.getDataList().size(); i++) {
						HashMap<?, ?> grupoResponse = (HashMap<?, ?>) grpDiagResponse.getDataList().get(i);
						GrupoDiagnosticoBean obj = new GrupoDiagnosticoBean();
						obj.setCodigo((String) grupoResponse.get("codgru"));
						obj.setDescripcion((String) grupoResponse.get("nomgru"));
						obj.setRn((Integer) grupoResponse.get("rn"));

						listaGrupoDiagnostico.add(obj);
					}

					grpDiagResponse.setDataList(listaGrupoDiagnostico);
				} else {
					log.error(this.getClass().getName() + ".getListarGrupoDiagnostico: " + audi.getMensajeRespuesta());
				}
			} else {
				grpDiagResponse = GenericUtil.responseErrorList("Error en el Servidor Oncosys Diagnóstico.");
			}
		} catch (Exception e) {
			log.error(".getListarGrupoDiagnostico: " + e.getMessage());
			grpDiagResponse = GenericUtil.responseErrorList(e.getMessage());
		}

		return grpDiagResponse;
	}

	@Override
	public WsResponse obtenerGrupoDiagnostico(HttpHeaders headers, GrupoDiagnosticoRequest request) throws Exception {

		urlListaGrpDiag = propiedades.getOncoDiagnostico() + "/consulta/grupodiagnostico";

		return null;
	}
}
