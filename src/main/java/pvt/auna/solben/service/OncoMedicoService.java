package pvt.auna.solben.service;

import org.springframework.http.HttpHeaders;

import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.MedicoRequest;

public interface OncoMedicoService {

    WsResponse obtenerMedicoTratante(HttpHeaders headers, MedicoRequest request);
}
