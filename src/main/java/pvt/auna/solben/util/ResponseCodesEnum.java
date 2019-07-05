package pvt.auna.solben.util;

import java.util.Date;

public enum ResponseCodesEnum {

    SUCCESS("0"),
    FAIL("1"),
    FAIL_SERVER("-1"),
    FAIL_SERVER_ONCOSYS("-2"),
	FECHA_TRANSACCION(""),
	ERROR("Error Desconocido");

    String code;
    String fec ;

    ResponseCodesEnum(String code){

        this.code = code;
    }

    public String getCode() {

        return this.code;
    }
    
    public String getFec() {

        return this.fec = new Date().toString();
    }
    
   /*
    *  Date date = new Date();
	DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String fecha = hourdateFormat.format(date);*/

}
