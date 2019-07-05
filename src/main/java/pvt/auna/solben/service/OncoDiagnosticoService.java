package pvt.auna.solben.service;

import org.springframework.http.HttpHeaders;
import pvt.auna.solben.model.api.request.GrupoDiagnosticoRequest;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.DiagnosticoRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;

public interface OncoDiagnosticoService {

	ResponseOnc getListarDiagnostico(HttpHeaders headers) throws Exception;

	WsResponse obtenerDiagnostico(HttpHeaders headers, DiagnosticoRequest request) throws Exception;

	ResponseOnc getListarGrupoDiagnostico(HttpHeaders headers) throws Exception;

	WsResponse obtenerGrupoDiagnostico(HttpHeaders headers, GrupoDiagnosticoRequest request) throws Exception;
}
