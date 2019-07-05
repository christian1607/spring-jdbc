package pvt.auna.solben.dao;

import pvt.auna.solben.model.api.HeaderBean;
import pvt.auna.solben.model.api.request.ActualizarSolPrelimRequest;
import pvt.auna.solben.model.api.request.RegistrarCartaGarantiaRequest;
import pvt.auna.solben.model.api.request.SolicitudPreliminarRequest;
import pvt.auna.solben.model.api.response.SolbenActualizarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistraCartaGarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistrarResponse;

public interface SolbenDao {

	SolbenRegistrarResponse getScgSolbenAndInsertSolPreliminar(SolicitudPreliminarRequest request, HeaderBean header);

	SolbenActualizarResponse actualizarSolben(ActualizarSolPrelimRequest request, HeaderBean header);

	SolbenRegistraCartaGarResponse registrarListaCartaGarantiaSolben(RegistrarCartaGarantiaRequest request, HeaderBean header);
}
