package pvt.auna.solben.service;

import org.springframework.http.HttpHeaders;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.request.AfiliadosRequest;
import pvt.auna.solben.model.api.request.ListaPacienteRequest;
import pvt.auna.solben.model.api.request.PacienteRequest;
import pvt.auna.solben.model.api.response.ResponseOnc;

public interface OncoPacienteService {

	WsResponse obtenerPaciente(PacienteRequest paciente, HttpHeaders headers) throws Exception;

	ResponseOnc obtenerListaPacientexCodigos(AfiliadosRequest request, HttpHeaders headers) throws Exception;

	ResponseOnc obtenerListaPacientexDatos(ListaPacienteRequest request, HttpHeaders headers);
}
