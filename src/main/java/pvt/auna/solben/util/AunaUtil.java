package pvt.auna.solben.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import pvt.auna.solben.model.api.HeaderBean;
import pvt.auna.solben.model.api.response.AudiResponse;
import pvt.auna.solben.model.api.response.ResponseGenerico;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AunaUtil<T> {

	private static final Logger LOG = LoggerFactory.getLogger(AunaUtil.class);


	public HeaderBean validHeader(HttpHeaders headers) throws SolbenException {
		HeaderBean header = null;
		List<String> idTransaccion;
		List<String> fechaTransaccion;
		try {
			idTransaccion = headers.get(AunaDefine.HEAD_ID_TRX);
			fechaTransaccion = headers.get(AunaDefine.HEAD_FEC_TRX);

			if (idTransaccion == null && fechaTransaccion == null) {
				throw new SolbenException("Error de validacion de datos: Datos de cabecera requerido","8");
			}

			header = new HeaderBean(idTransaccion.get(0), fechaTransaccion.get(0));
		} catch (SolbenException e) {
			LOG.error("[AUNA UTIL][ERROR]",e);
			throw new SolbenException(e.getMessage(),e.getCodResponse());
		} catch (Exception e) {
			LOG.error("[AUNA UTIL][ERROR]",e);
			throw new SolbenException("Error interno del servidor","-2");
		}
		return header;
	}

	public ResponseGenerico getResponse(HeaderBean header, String index, ArrayList<Object> objectList) {

		if (objectList == null) {
			objectList = new ArrayList<>();
		}

		ResponseGenerico response = null;

		switch (index) {

		case "0":
			response = new ResponseGenerico(
					new AudiResponse(header.getIdTransaccion(), getDateTimeZone(), "0", AunaDefine.RES_OK), objectList);
			break;
		case "2":
			response = new ResponseGenerico(
					new AudiResponse(header.getIdTransaccion(), getDateTimeZone(), "2", AunaDefine.RES_NOT_FOUND_DATA),
					objectList);
			break;
		case "1":
			response = new ResponseGenerico(
					new AudiResponse(header.getIdTransaccion(), getDateTimeZone(), "1", AunaDefine.RES_PARAM_ERR),
					objectList);
			break;
		case "-2":
			response = new ResponseGenerico(
					new AudiResponse(header.getIdTransaccion(), getDateTimeZone(), "-2", AunaDefine.RES_INT_ERR),
					objectList);
			break;
		case "-4":
			response = new ResponseGenerico(new AudiResponse("", getDateTimeZone(), "-4", AunaDefine.RES_HEAD_ERRR),
					objectList);
			break;
		}

		return response;
	}

	private String getDateTimeZone() {
		String fecha = ZonedDateTime.now().toString();
		fecha = fecha.substring(0, 29);
		return fecha;
	}
}
