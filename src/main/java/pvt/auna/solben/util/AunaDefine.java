package pvt.auna.solben.util;

public class AunaDefine {

	// ONCOSYS
	public static final String SERVICIO_CONTACTO_AFILIADO = "ContactoAfiliado";
	public static final String SERVICIO_AFILIADO = "BuscarAfilado";
	public static final String PATH_CONTACTO_AFILIADO = "/qserver/sp/oncosys-aseg-contacto-afi";
	public static final String PATH_AFILIADO = "/qserver/sp/oncosys-aseg-consulta-afi";
	public static final String PATH_PLAN_AFILIADO = "/qserver/sp/oncosys-aseg-plan-afi";
	public static final String PATH_NOMBRE_AFILIADO = "/qserver/sp/oncosys-aseg-nombres-afi";
	public static final String PATH_OBTENER_PACIENTE= "/qserver/sp/oncosys-aseg-paciente-afi/1/10/";
	// Headers
	public static final String HEAD_ID_TRX = "idTransaccion";
	public static final String HEAD_FEC_TRX = "fechaTransaccion";

	// Mensajes de Respuesta
	public static final String RES_OK = "Consulta Exitosa";// 0
	public static final String RES_NOT_FOUND_DATA = "No se encontraron datos";// 2
	public static final String RES_PARAM_ERR = "Parametros de entrada incorrectos";// 1
	public static final String RES_INT_ERR = "Error interno del servidor";// -2
	public static final String RES_HEAD_ERRR = "Error cabecera invalida";// -4
}
