package pvt.auna.solben.service;

import org.springframework.http.HttpHeaders;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.ClinicaRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;

public interface OncoClinicaService {

	WsResponse obtenerClinica(ClinicaRequest clinica, HttpHeaders headers) throws Exception;

	ResponseOnc obtenerListaClinica(ClinicaRequest request, HttpHeaders headers) throws Exception;

	ResponseOnc obtenerListaClinicaXCodigos(ClinicaRequest clinicaRequest, HttpHeaders headers);

}
