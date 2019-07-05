package pvt.auna.solben.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pvt.auna.solben.dao.SolbenDao;
import pvt.auna.solben.model.api.HeaderBean;
import pvt.auna.solben.model.api.request.ActualizarSolPrelimRequest;
import pvt.auna.solben.model.api.request.RegistrarCartaGarantiaRequest;
import pvt.auna.solben.model.api.request.SolicitudPreliminarRequest;
import pvt.auna.solben.model.api.response.SolbenActualizarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistraCartaGarResponse;
import pvt.auna.solben.model.api.response.SolbenRegistrarResponse;
import pvt.auna.solben.service.SolbenService;

@Service
public class SolbenServiceImpl implements SolbenService {


	private SolbenDao solbenWebServiceDao;

	@Autowired
	public SolbenServiceImpl(SolbenDao solbenWebServiceDao) {
		this.solbenWebServiceDao = solbenWebServiceDao;
	}

	@Override
	public SolbenRegistrarResponse registrarSolPreliminar(SolicitudPreliminarRequest request, HeaderBean header) {
		return solbenWebServiceDao.getScgSolbenAndInsertSolPreliminar(request,header);
	}


	@Override
	public SolbenActualizarResponse actualizarSolben(ActualizarSolPrelimRequest request, HeaderBean header) {
		return solbenWebServiceDao.actualizarSolben(request, header);
	}

	@Override
	public SolbenRegistraCartaGarResponse registrarListaCartaGarantiaSolben(RegistrarCartaGarantiaRequest request, HeaderBean header) {
		return solbenWebServiceDao.registrarListaCartaGarantiaSolben(request, header);
	}
}
