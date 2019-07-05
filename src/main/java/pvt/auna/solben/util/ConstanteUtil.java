package pvt.auna.solben.util;

/**
 * @author usuario
 *
 */
public class ConstanteUtil {

	/** Datos de conexión de base de datos */

	public static final String ESQUEMA_ONTPFC = "ONTPFC";

	public static final String ESQUEMA_ONTPAC = "ONTPAC";

	public static final String PAQUETE_SOLBEN_FC = "PCK_PFC_SOLBEN";

	public static final String PAQUETE_SOLBEN_AC = "PCK_PAC_SOLBEN";


	/** MENSAJES WS **/

	public static final String FORMATO_FECHA_HORA_EXTENDIDO = "dd/MM/yyyy hh:mm a";
	public static final String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_dd_MM_yyyy_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMATO_FECHA_HH_mm_ss = "HH:mm:ss";



	/**
	 * Constantes de Webservices Maestra
	 */

	public static final String KEY_BEARER_TOKEN = "Bearer ";

	/**
	 * Constantes detalle Preliminar
	 */
	public static final String ESTADO_PRELIMINAR = "PENDIENTE";


	public static final Integer registroIni = 1;
	public static final Integer registroFinGrupoDiag = 300;
	public static final Integer registroFinDiagnostico = 200;
	public static final Integer registroFinClinicas = 100;

	public static final Integer tipoTodos = 1;
	public static final Integer tipoXCod = 2;
	public static final Integer tipoXDes = 3;
	public static final String TIPO_CODIGO_AFILIADO = "3";
	public static final Integer tipoCmp = 3;
	
	public static final String INDICE_PAGINACION = "1";
	public static final String SIZE_PAGINACION = "10";
	
	//validación errores funcionales
	//codigos a nivel general
	public static final String CODIGO_EXITOSO = "0";
	public static final String MENSAJE_EXITOSO = "Operación exitosa";
	
	public static final String CODIGO_TOKEN_EXPIRADO = "1";
	public static final String MENSAJE_TOKEN_EXPIRADO = "La clave token ha expirado";
	
	public static final String CODIGO_ERROR_VALIDACION_DATO = "8";
	public static final String MENSAJE_ERROR_VALIDACION_DATO = "Error validación de datos: [field]";
	
	//codigos de errores para el metodo 1 registrar-scg
	public static final String METODO1_CODIGO_ERROR_SCG_EXISTE = "2";
	public static final String METODO1_MENSAJE_ERROR_SCG_EXISTE = "El número de Solicitud de Carta de Garantía [codScgSolben] ya se encuentra registrada en el Módulo de Farmacia Compleja con el número de solicitud preliminar [codSolPre] con fecha de creación [fechaCreacion] ";
	
	public static final String METODO1_CODIGO_ERROR_PACIENTE_NO_EXISTE = "5";
	public static final String METODO1_MENSAJE_ERROR_PACIENTE_NO_EXISTE = "El paciente [codAfiPaciente] no se encuentra registrado en Oncosys y/o el código de diagnóstico [codDiagnostico] no se encuentra registrado en el Oncosys.";

	
	//validación errores técnicos general
	public static final String CODIGO_ERROR_TIMEOUT = "-1";
	public static final String MENSAJE_ERROR_TIMEOUT = "Erro de TimeOut al acceder [componente]";
	
	public static final String CODIGO_ERROR_INTERNO = "-2";
	public static final String MENSAJE_ERROR_INTERNO = "Error interno del servidor [componente]";
	
	public static final String CODIGO_ERROR_ACCESO_DENEGADO = "-3";
	public static final String MENSAJE_ERROR_ACCESO_DENEGADO = "Error de acceso denegado al recurso [componente]";
	
	
}
