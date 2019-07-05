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
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.ClinicaRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;
import pvt.auna.solben.model.bean.ClinicaBean;
import pvt.auna.solben.service.OncoClinicaService;
import pvt.auna.solben.util.GenericUtil;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OncoClinicaServiceImpl implements OncoClinicaService {

	private static final Logger LOG = LoggerFactory.getLogger(OncoClinicaServiceImpl.class);
	private static final String EXITOSO = "0";

	private RestTemplate restTemplate;

	private OncoPropiedades prop;

	@Autowired
	public OncoClinicaServiceImpl(RestTemplate restTemplate, OncoPropiedades prop) {
		this.restTemplate = restTemplate;
		this.prop = prop;
	}

	@Override
	public WsResponse obtenerClinica(ClinicaRequest clinicaRq, HttpHeaders headers){
		ResponseOnc clinicaResponse;
		ClinicaBean clinica;
		WsResponse response = new WsResponse();

		String UrlVchar = prop.getOncoGenerico() + "/listar/clinicas";

		try {
			HttpEntity<ClinicaRequest> request = new HttpEntity<>(clinicaRq, headers);
			clinicaResponse = restTemplate.postForObject(UrlVchar, request, ResponseOnc.class);

			if (clinicaResponse != null && clinicaResponse.getAudiResponse() != null) {
				AudiResponse audi = clinicaResponse.getAudiResponse();

				if (audi.getCodigoRespuesta().equalsIgnoreCase("0")) {
					if (clinicaResponse.getDataList() != null && clinicaResponse.getDataList().size() == 1) {
						HashMap<?, ?> cliResponse = (HashMap<?, ?>) clinicaResponse.getDataList().get(0);
						clinica = new ClinicaBean();

						clinica.setCodcli((String) cliResponse.get("codcli"));
						clinica.setNomcli((String) cliResponse.get("nomcli"));
						clinica.setRn((Integer) cliResponse.get("rn"));
						
						response.setAudiResponse(clinicaResponse.getAudiResponse());
						response.setData(clinica);
					} else {
						audi = GenericUtil.obtenerResponse(audi, "2", "Se encontraron más de un resultado.");
						LOG.error(response.getAudiResponse().getMensajeRespuesta());
						response.setAudiResponse(audi);
					}
				} else {
					LOG.error(".obtenerClinica: " + audi.getMensajeRespuesta());
				}
			} else {
				response = GenericUtil.responseErrorData("Error en Servidor Oncosys clínicas");
				LOG.error(".obtenerClinica: " + response.getAudiResponse().getMensajeRespuesta());
			}

		} catch (Exception e) {
			response = GenericUtil.responseErrorData(e.getMessage());
			LOG.error(".obtenerClinica: " + e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseOnc obtenerListaClinica(ClinicaRequest request, HttpHeaders headers) {

		ResponseOnc response;
		ArrayList<ClinicaBean> listaClinicas;

		String UrlVchar = prop.getOncoGenerico() + "/listar/clinicas";

		try {
			HttpEntity<ClinicaRequest> rqClinica = new HttpEntity<>(request, headers);
			response = restTemplate.postForObject(UrlVchar, rqClinica, ResponseOnc.class);

			if (response != null && response.getAudiResponse() != null) {
				AudiResponse audi = response.getAudiResponse();

				if (audi.getCodigoRespuesta().equals(EXITOSO)) {
					listaClinicas = new ArrayList<>();
					mapearDatosClinica(response, listaClinicas);
				} else {
					LOG.error(".obtenerListaClinica(): " + audi.getMensajeRespuesta());
				}
			} else {
				response = GenericUtil.responseErrorList("Error en el Servidor Oncosys Clinicas.");
			}
		} catch (Exception e) {
			LOG.error(".obtenerListaClinica(): " + e.getMessage());
			response = GenericUtil.responseErrorList(e.getMessage());
		}

		return response;
	}

	@Override
	public ResponseOnc obtenerListaClinicaXCodigos(ClinicaRequest clinicaRequest, HttpHeaders headers) {
		ResponseOnc response;
		ArrayList<ClinicaBean> listaClinicas;

		String UrlVchar = prop.getOncoGenerico() + "/listar/clinicas-codigo";

		try {
			HttpEntity<ClinicaRequest> rqClinica = new HttpEntity<>(clinicaRequest, headers);
			response = restTemplate.postForObject(UrlVchar, rqClinica, ResponseOnc.class);

			if (response != null && response.getAudiResponse() != null) {
				AudiResponse audi = response.getAudiResponse();

				if (audi.getCodigoRespuesta().equals(EXITOSO)) {
					listaClinicas = new ArrayList<>();
					mapearDatosClinica(response, listaClinicas);

				} else {
					LOG.error(".obtenerListaClinicaXcodigos(): " + audi.getMensajeRespuesta());
				}
			} else {
				response = GenericUtil.responseErrorList("Error en el Servidor Oncosys Clinicas.");
			}
		} catch (Exception e) {
			LOG.error(".obtenerListaClinicaXcodigos(): " + e.getMessage());
			response = GenericUtil.responseErrorList(e.getMessage());
		}

		return response;
	}

	private void mapearDatosClinica(ResponseOnc response, ArrayList<ClinicaBean> listaClinicas) {
		for (int i = 0; i < response.getDataList().size(); i++) {
			HashMap<?, ?> clinResponse = (HashMap<?, ?>) response.getDataList().get(i);

			ClinicaBean objClinica = new ClinicaBean();
			objClinica.setCodcli((String) clinResponse.get("codcli"));
			objClinica.setNomcli((String) clinResponse.get("nomcli"));
			objClinica.setRn((Integer) clinResponse.get("rn"));

			listaClinicas.add(objClinica);
		}

		response.setDataList(listaClinicas);
	}

}
