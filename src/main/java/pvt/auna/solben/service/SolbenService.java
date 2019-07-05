package pvt.auna.solben.service;

import pvt.auna.solben.model.api.HeaderBean;
import pvt.auna.solben.model.api.request.ActualizarSolPrelimRequest;
import pvt.auna.solben.model.api.request.RegistrarCartaGarantiaRequest;
import pvt.auna.solben.model.api.request.SolicitudPreliminarRequest;
import pvt.auna.solben.model.api.response.SolbenActualizarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistraCartaGarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistrarResponse;

public interface SolbenService {

	SolbenRegistrarResponse registrarSolPreliminar(SolicitudPreliminarRequest request, HeaderBean headers );

	SolbenActualizarResponse actualizarSolben(ActualizarSolPrelimRequest request, HeaderBean header);

	SolbenRegistraCartaGarResponse registrarListaCartaGarantiaSolben(RegistrarCartaGarantiaRequest request, HeaderBean header);

}
