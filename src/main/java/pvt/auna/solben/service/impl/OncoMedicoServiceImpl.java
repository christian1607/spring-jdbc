package pvt.auna.solben.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pvt.auna.solben.config.OncoPropiedades;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.MedicoRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;
import pvt.auna.solben.model.bean.MedicoBean;
import pvt.auna.solben.service.OncoMedicoService;

import java.util.HashMap;

@Service
public class OncoMedicoServiceImpl implements OncoMedicoService {
	
	private static final Logger log = LoggerFactory.getLogger(OncoDiagnosticoServiceImpl.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private OncoPropiedades prop;
	
	String urlMedicoTrat;

	@Override
	public WsResponse obtenerMedicoTratante(HttpHeaders headers, MedicoRequest request) {
		WsResponse medicoResponse = new WsResponse();
		ResponseOnc response = new ResponseOnc();
		MedicoBean medicoTratante = null;
		
		urlMedicoTrat = this.prop.getOncoMedico() + "/buscar";
		
		try {
			HttpEntity<MedicoRequest> rqMed = new HttpEntity<>(request, headers);
			response = restTemplate.postForObject(urlMedicoTrat, rqMed, ResponseOnc.class);
			
			medicoResponse.setAudiResponse(response.getAudiResponse());
			
			if (medicoResponse.getAudiResponse().getCodigoRespuesta().equalsIgnoreCase("0")) {
				if (response.getDataList().size() == 1) {
					HashMap<?, ?> mediResponse = (HashMap<?, ?>) response.getDataList().get(0);
					medicoTratante = new MedicoBean();
					
					medicoTratante.setCodmed((String) mediResponse.get("codmed"));
					medicoTratante.setApepat((String) mediResponse.get("apepat"));
					medicoTratante.setApemat((String) mediResponse.get("apemat"));
					medicoTratante.setNommed((String) mediResponse.get("nommed"));
					medicoTratante.setCmptra((String) mediResponse.get("cmptra"));
					medicoTratante.setRn((Integer) mediResponse.get("rn"));
					
					medicoResponse.setData(medicoTratante);
					
				} else {
					medicoResponse.getAudiResponse().setCodigoRespuesta("2");
					medicoResponse.getAudiResponse().setMensajeRespuesta("Se obtuvieron más de un resultado.");
					log.error(this.getClass().getName() + ".obtenerMedicoTratante: " + medicoResponse.getAudiResponse().getMensajeRespuesta());
					throw new Exception(medicoResponse.getAudiResponse().getMensajeRespuesta());
				}
			} else {
				log.error(this.getClass().getName() + ".obtenerMedicoTratante: " + medicoResponse.getAudiResponse().getMensajeRespuesta());
			}
			
		} catch (Exception e) {
			medicoResponse.getAudiResponse().setCodigoRespuesta("99");
			medicoResponse.getAudiResponse().setMensajeRespuesta(e.getMessage());
			log.error(this.getClass().getName() + ".obtenerMedicoTratante: " + e.getMessage());
			medicoResponse.setData(null);
		}
		
		return medicoResponse;
	}

}
