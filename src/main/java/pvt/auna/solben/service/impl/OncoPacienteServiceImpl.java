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
import pvt.auna.solben.model.api.request.AfiliadosRequest;
import pvt.auna.solben.model.api.request.ListaPacienteRequest;
import pvt.auna.solben.model.api.request.PacienteRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;
import pvt.auna.solben.model.bean.PacienteBean;
import pvt.auna.solben.service.OncoPacienteService;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OncoPacienteServiceImpl implements OncoPacienteService {

	private static final Logger log = LoggerFactory.getLogger(OncoPacienteServiceImpl.class);

	@Autowired
	private OncoPropiedades prop;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public WsResponse obtenerPaciente(PacienteRequest pcteReq, HttpHeaders headers) {
		ResponseOnc pacienteResponse = new ResponseOnc();
		PacienteBean paciente = null;
		WsResponse response = new WsResponse();

		String urlPcte = prop.getOncoAfiliado();

		if (pcteReq.getCodafir() != null) {
			try {
				HttpEntity<PacienteRequest> request = new HttpEntity<>(pcteReq, headers);
				pacienteResponse = restTemplate.postForObject(urlPcte + "/buscar", request,
						ResponseOnc.class);

				response.setAudiResponse(pacienteResponse.getAudiResponse());

				if (response.getAudiResponse().getCodigoRespuesta().equalsIgnoreCase("0")) {
					if (pacienteResponse.getDataList().size() == 1) {
						HashMap<?, ?> responseOnc = (HashMap<?, ?>) pacienteResponse.getDataList().get(0);
						paciente = new PacienteBean();
						paciente.setCodafir((String) responseOnc.get("codafir"));
						paciente.setApepat((String) responseOnc.get("apepat"));
						paciente.setApemat((String) responseOnc.get("apemat"));
						paciente.setNombr1((String) responseOnc.get("nombr1"));
						paciente.setNombr2((String) responseOnc.get("nombr2"));
						paciente.setEdaafi((Integer) responseOnc.get("edaafi"));
						paciente.setSexafi((String) responseOnc.get("sexafi"));
						paciente.setEspaci((String) responseOnc.get("espaci"));
						paciente.setEstafi((String) responseOnc.get("estafi"));

						response.setData(paciente);

					} else {
						response.getAudiResponse().setCodigoRespuesta("10");
						response.getAudiResponse().setMensajeRespuesta("Se obtuvieron más de un resultado");
						log.error(response.getAudiResponse().getMensajeRespuesta());
						response.setData(null);
					}
				} else {
					response.setData(null);
					log.error(response.getAudiResponse().getMensajeRespuesta());
				}

			} catch (Exception e) {
				response.getAudiResponse().setCodigoRespuesta("99");
				response.getAudiResponse().setMensajeRespuesta(e.getMessage());
				response.setData(null);
				log.error(".obtenerPaciente" + e.getMessage());
			}
		}

		return response;
	}

	@Override
	public ResponseOnc obtenerListaPacientexCodigos(AfiliadosRequest request, HttpHeaders headers) {
		ResponseOnc pacienteResponse = new ResponseOnc();
		ArrayList<PacienteBean> listaPcte = null;

		String urlPcte = prop.getOncoAfiliado();

		try {
			HttpEntity<AfiliadosRequest> rqPcte = new HttpEntity<>(request, headers);
			pacienteResponse = restTemplate.postForObject(urlPcte + "/buscar/nombre", rqPcte, ResponseOnc.class);

			AudiResponse audi = pacienteResponse.getAudiResponse();

			if (audi.getCodigoRespuesta().equals("0")) {
				listaPcte = new ArrayList<PacienteBean>();
				for (int i = 0; i < pacienteResponse.getDataList().size(); i++) {
					HashMap<?, ?> pcteResponse = (HashMap<?, ?>) pacienteResponse.getDataList().get(i);

					PacienteBean objPcte = new PacienteBean();
					objPcte.setCodafir((String) pcteResponse.get("codafir"));
					objPcte.setApepat((String) pcteResponse.get("pv_apepat"));
					objPcte.setApemat((String) pcteResponse.get("pv_apemat"));
					objPcte.setNombr1((String) pcteResponse.get("nombr1"));
					objPcte.setNombr2((String) pcteResponse.get("nombr2"));
					objPcte.setSexafi((String) pcteResponse.get("sexafi"));

					listaPcte.add(objPcte);
				}

				pacienteResponse.setDataList((ArrayList<PacienteBean>) listaPcte);

			} else {
				log.error("Error No muestra Pacientes. " + audi.getMensajeRespuesta());
				pacienteResponse.setDataList(null);
			}

		} catch (Exception e) {
			pacienteResponse.getAudiResponse().setCodigoRespuesta("99");
			pacienteResponse.getAudiResponse().setMensajeRespuesta(e.getMessage());
			pacienteResponse.setDataList(null);
			log.error("Error No muestra Pacientes" + e.getMessage());
		}
		
		return pacienteResponse;
	}

	@Override
	public ResponseOnc obtenerListaPacientexDatos(ListaPacienteRequest request, HttpHeaders headers) {
		ResponseOnc pacienteResponse = new ResponseOnc();

		String urlPcte = prop.getOncoAfiliado();
		ArrayList<PacienteBean> listaPcte = null;

		try {
			HttpEntity<ListaPacienteRequest> rqPcte = new HttpEntity<ListaPacienteRequest>(request, headers);
			pacienteResponse = restTemplate.postForObject(urlPcte + "/buscar", rqPcte, ResponseOnc.class);

			if (pacienteResponse.getAudiResponse() != null) {
				if (pacienteResponse.getAudiResponse().getCodigoRespuesta().equals("0")) {
					listaPcte = new ArrayList<PacienteBean>();
					for (int i = 0; i < pacienteResponse.getDataList().size(); i++) {
						HashMap<?, ?> pcteResponse = (HashMap<?, ?>) pacienteResponse.getDataList().get(i);

						PacienteBean objPcte = new PacienteBean();
						objPcte.setRn((Integer) pcteResponse.get("rn"));
						objPcte.setCodafir((String) pcteResponse.get("codafir"));
						objPcte.setApepat((String) pcteResponse.get("apepat"));
						objPcte.setApemat((String) pcteResponse.get("apemat"));
						objPcte.setNombr1((String) pcteResponse.get("nombr1"));
						objPcte.setNombr2((String) pcteResponse.get("nombr2"));

						listaPcte.add(objPcte);
					}

					pacienteResponse.setDataList(listaPcte);
				} else {
					pacienteResponse.setDataList(null);
				}
			} else {
				pacienteResponse.getAudiResponse().setCodigoRespuesta("1");
				pacienteResponse.getAudiResponse().setMensajeRespuesta("Error al obtener coindencias.");
				pacienteResponse.setDataList(null);
			}

		} catch (Exception e) {
			String mensaje = "Error al buscar coincidencias. " + e.getMessage();
			log.error("obtenerListaPacientexDatos(): " + mensaje);
			pacienteResponse.getAudiResponse().setCodigoRespuesta("99");
			pacienteResponse.getAudiResponse().setMensajeRespuesta(mensaje);
			pacienteResponse.setDataList(null);
		}

		return pacienteResponse;
	}
}
