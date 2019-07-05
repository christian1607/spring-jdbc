package pvt.auna.solben.util;

import org.springframework.http.HttpHeaders;
import pvt.auna.solben.model.api.WsResponse;
import pvt.auna.solben.model.api.response.AudiResponse;
import pvt.auna.solben.model.api.response.ResponseOnc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class GenericUtil {
	public static HttpHeaders obtenerCabecera() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("idTransaccion", getUniqueID());
		headers.add("fechaTransaccion", DateUtils.getDateToStringDDMMYYYY(new Date()));
		return headers;
	}

	public static String getUniqueID() {
		String r = "";
		try {
			MessageDigest salt = MessageDigest.getInstance("SHA-256");
			salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
			r = bytesToHex(salt.digest());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}

	public static byte[] _bytesToHex(byte[] data) {
		String encoded = javax.xml.bind.DatatypeConverter.printHexBinary(data);
		return encoded.getBytes();
	}

	public static String bytesToHex(String data) {
		return new String(_bytesToHex(data.getBytes()));
	}

	public static String bytesToHex(byte[] data) {
		return new String(_bytesToHex(data));
	}

	public static String numberFormat(double src, String fmt) {
		fmt = fmt.replaceAll("#", "0");
		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		return df.format(src);
	}

	public static String numberFormat(long src, String fmt) {
		fmt = fmt.replaceAll("#", "0");
		java.text.DecimalFormat df = new java.text.DecimalFormat(fmt);
		return df.format(src);
	}
	
	public static AudiResponse obtenerResponse(AudiResponse audiRes, String codigo, String mensaje) {
		AudiResponse audi = audiRes;
		audi.setCodigoRespuesta(codigo);
		audi.setMensajeRespuesta(mensaje);
		return audi;
	}
	
	public static ResponseOnc responseErrorList(String mensaje) {
		ResponseOnc response = new ResponseOnc();
		response.setAudiResponse(
				new AudiResponse(getUniqueID(), DateUtils.getDateToStringDDMMYYYY(new Date())));
		response.getAudiResponse().setCodigoRespuesta("-1");
		response.getAudiResponse().setMensajeRespuesta(mensaje);
		response.setDataList(null);
		
		return response;
	}
	
	public static WsResponse responseErrorData(String mensaje) {
		WsResponse response = new WsResponse();
		response.setAudiResponse(
				new AudiResponse(getUniqueID(), DateUtils.getDateToStringDDMMYYYY(new Date())));
		response.getAudiResponse().setCodigoRespuesta("-1");
		response.getAudiResponse().setMensajeRespuesta(mensaje);
		response.setData(null);
		return response;
	}
	
	public static double decimal(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
