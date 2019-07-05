package pvt.auna.solben.dao.impl;


import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.AbstractSqlTypeValue;
import org.springframework.stereotype.Repository;
import pvt.auna.solben.dao.SolbenDao;
import pvt.auna.solben.model.api.HeaderBean;
import pvt.auna.solben.model.api.request.ActualizarSolPrelimRequest;
import pvt.auna.solben.model.api.request.RegistrarCartaGarantiaRequest;
import pvt.auna.solben.model.api.request.SolicitudPreliminarRequest;
import pvt.auna.solben.model.api.response.*;
import pvt.auna.solben.util.ConstanteUtil;
import pvt.auna.solben.util.DateUtils;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

@Repository
public class SolbenDaoImpl implements SolbenDao {

    private static final Logger LOG = LoggerFactory.getLogger(SolbenDaoImpl.class);

    private static final int EXITOSO = 0;
    private static final String ERROR_INTERNO_DEL_SERVIDOR = "Error interno del Servidor";
    private static final String COD_ERROR_INTERN_SERVER = "-2";

    //@Qualifier("dataSource")
    @Autowired
    @Qualifier("concurrenciaDataSource")
    private DataSource concurrenciaDataSource;

    @Qualifier("fcomplejaDataSource")
    @Autowired
    private DataSource fcomplejaDataSource;

    /**
     * Registrar solicitud preliminar de Solicitud de Carta Garantia
     * author: Christian Altamirano
     *
     */
    @Override
    public SolbenRegistrarResponse getScgSolbenAndInsertSolPreliminar(SolicitudPreliminarRequest request, HeaderBean header) {


        LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][getScgSolbenAndInsertSolPreliminar][SP_PFC_SI_SCG_SOLBEN_PREL][INICIO]");
        LOG.info("[" + header.getIdTransaccion() + "][Parametros de entrada]" + "[REQUEST][" + request.toString() + "]" );

        Map<String, Object> out;
        SolbenRegistrarResponse response = new SolbenRegistrarResponse();
        Date date = new Date();
        AuditResponse auditResponse;
        final String PROC_REGISTRAR_SOL_PREL_SCG = "SP_PFC_SI_SCG_SOLBEN_PREL_T";
        try {

            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(fcomplejaDataSource)
                   // .withSchemaName(ConstanteUtil.ESQUEMA_ONTPFC)
                    .withSchemaName(ConstanteUtil.ESQUEMA_ONTPFC)
                   // .withCatalogName(ConstanteUtil.PAQUETE_SOLBEN_FC)
                    .withCatalogName("PCK_PFC_SOLBEN_TEMP")
                    .withProcedureName(PROC_REGISTRAR_SOL_PREL_SCG);

            MapSqlParameterSource in = new MapSqlParameterSource();

            in.addValue("PV_COD_SCG_SOLBEN", request.getCodScgSolben(), Types.VARCHAR);
            in.addValue("PV_COD_CLINICA", request.getCodClinica(), Types.VARCHAR);
            in.addValue("PV_COD_AFI_PACIENTE", request.getCodAfiPaciente(), Types.VARCHAR);
            in.addValue("PN_EDAD_PACIENTE", request.getEdadPaciente(), Types.NUMERIC);
            in.addValue("PV_DES_CONTRATANTE", request.getDesContratante(), Types.VARCHAR);
            in.addValue("PV_DES_PLAN", request.getDesPlan(), Types.VARCHAR);
            in.addValue("PV_FEC_AFILIACION",request.getFecAfiliacion(), Types.VARCHAR);
            in.addValue("PV_COD_DIAGNOSTICO", request.getCodDiagnostico(), Types.VARCHAR);
            in.addValue("PV_CMP_MEDICO", request.getCmpMedico(), Types.VARCHAR);
            in.addValue("PV_MEDICO_TRATANTE_PRESCRIPTOR", request.getMedicoTratantePrescriptor(), Types.VARCHAR);
            in.addValue("PV_FEC_RECETA",request.getFecReceta(), Types.VARCHAR);
            in.addValue("PV_FEC_QUIMIO", request.getFecQuimio(), Types.VARCHAR);
            in.addValue("PV_FEC_HOSP_INICIO", request.getFecHospInicio(), Types.VARCHAR);
            in.addValue("PV_FEC_HOSP_FIN", request.getFecHospFin(), Types.VARCHAR);
            in.addValue("PV_FEC_SCG_SOLBEN", request.getFecScgSolben(), Types.VARCHAR);
            in.addValue("PV_HORA_SCG_SOLBEN", request.getHoraScgSolben(), Types.VARCHAR);
            in.addValue("PV_TIPO_SCG_SOLBEN", request.getTipoScgSolben(), Types.VARCHAR);
            in.addValue("PV_ESTADO_SCG", request.getCodEstadoScg(), Types.VARCHAR);
            in.addValue("PV_DESC_MEDICAMENTO", request.getDescMedicamento(), Types.VARCHAR);
            in.addValue("PV_DESC_ESQUEMA", request.getDescEsquema(), Types.VARCHAR);
            in.addValue("PN_TOTAL_PRESUPUESTO", request.getTotalPresupuesto(), Types.NUMERIC);
            in.addValue("PV_DESC_PROCEDIMIENTO", request.getDescProcedimiento(), Types.VARCHAR);
            in.addValue("PV_PERSON_CONTACTO", request.getPersonContacto(), Types.VARCHAR);
            in.addValue("PV_OBS_CLINICA", request.getObsClinica(), Types.VARCHAR);
            in.addValue("PN_IND_VALIDA", request.getIndValida(), Types.NUMERIC);
            in.addValue("PV_TX_DATO_ADIC1", request.getTxDatoAdic1(), Types.VARCHAR);
            in.addValue("PV_TX_DATO_ADIC2", request.getTxDatoAdic2(), Types.VARCHAR);
            in.addValue("PV_TX_DATO_ADIC3", request.getTxDatoAdic3(), Types.VARCHAR);
            in.addValue("PV_FEC_ACTUAL", DateUtils.getDateToStringDDMMYYYHHMMSS(date), Types.VARCHAR);

            out = simpleJdbcCall.execute(in);

            auditResponse=new AuditResponse();
            auditResponse.setCodigoRespuesta(out.get("PN_OUT_COD_RESULTADO").toString());
            auditResponse.setMensajeRespuesta((String) out.get("PV_OUT_MSG_RESULTADO"));
            auditResponse.setIdTransaccion(header.getIdTransaccion());
            auditResponse.setFechaTransaccion(header.getFechaTransaccion());
            response.setAuditResponse(auditResponse);

            if (Integer.parseInt(out.get("PN_OUT_COD_RESULTADO").toString()) != EXITOSO) {
                response.setRegistroSolPreliminar(null);
                LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][getScgSolbenAndInsertSolPreliminar][SP_PFC_SI_SCG_SOLBEN_PREL][FIN]");
                return response;
            }

            RegistroSolPreliminar solPre=new RegistroSolPreliminar();

            Object ref = out.get("PV_OUT_COD_SCG_SOLBEN");
            solPre.setCodScgSolben(ref != null ? ref.toString() : null);

            ref = out.get("PN_OUT_COD_SOL_PRE");
            solPre.setCodSolPre(ref != null ? ref.toString() : null);

            ref = out.get("PV_OUT_FEC_SOL_PRE");
            solPre.setFecSolPre(ref != null ? ref.toString() : null);

            ref = out.get("PV_OUT_HORA_SOL_PRE");
            solPre.setHoraSolPre(ref != null ? ref.toString() : null);

            response.setRegistroSolPreliminar(solPre);
            response.setAuditResponse(auditResponse);

        } catch (Exception e) {
            auditResponse=new AuditResponse();
            auditResponse.setCodigoRespuesta(COD_ERROR_INTERN_SERVER);
            auditResponse.setMensajeRespuesta(ERROR_INTERNO_DEL_SERVIDOR);
            auditResponse.setIdTransaccion(header.getIdTransaccion());
            auditResponse.setFechaTransaccion(header.getFechaTransaccion());
            response.setRegistroSolPreliminar(null);
        }
        LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][getScgSolbenAndInsertSolPreliminar][SP_PFC_SI_SCG_SOLBEN_PREL][FIN]");
        return response;
    }

    /**
     * Proposito : Actualizar Estado de la SCG y CG Solben
     *
     */
    @Override
    public SolbenActualizarResponse actualizarSolben(ActualizarSolPrelimRequest request, HeaderBean header) {

        Map<String, Object> out;
        final String PROCEDURE = "SP_PFC_SU_SOLBEN_ACTUALIZAR_T";
        SolbenActualizarResponse response = new SolbenActualizarResponse();
        AuditResponse audiResponse;
        LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][actualizarSolben][SP_PFC_SU_SOLBEN_ACTUALIZAR][INICIO]");
        LOG.debug("[" + header.getIdTransaccion() + "][Parametros de entrada]" + "[REQUEST][" + request.toString() + "]" );

        try {

            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(fcomplejaDataSource)
                    .withSchemaName(ConstanteUtil.ESQUEMA_ONTPFC)
                   // .withCatalogName(ConstanteUtil.PAQUETE_SOLBEN_FC)
                    .withCatalogName("PCK_PFC_SOLBEN_TEMP")
                    .withProcedureName(PROCEDURE);


            MapSqlParameterSource in = new MapSqlParameterSource();

            in.addValue("PV_COD_SCG_SOLBEN", request.getCodScgSolben(), Types.VARCHAR);
            in.addValue("PV_COD_AFI_PACIENTE", request.getCodAfiPaciente(), Types.VARCHAR);
            in.addValue("PV_COD_ESTADO_SCG", request.getCodEstadoScg(), Types.NUMERIC);
            in.addValue("PN_TIPO_OPERACION", request.getTipoOperacion(), Types.NUMERIC);
            in.addValue("PV_NRO_CG", request.getNroCg(), Types.VARCHAR);
            in.addValue("PV_FEC_CG", request.getFecCg(), Types.VARCHAR);
            in.addValue("PV_TX_DATO_ADIC1", request.getTxDatoAdic1(), Types.VARCHAR);
            in.addValue("PV_TX_DATO_ADIC2", request.getTxDatoAdic2(), Types.VARCHAR);
            in.addValue("PV_TX_DATO_ADIC3", request.getTxDatoAdic3(), Types.VARCHAR);

            out = simpleJdbcCall.execute(in);


            audiResponse=new AuditResponse();
            audiResponse.setCodigoRespuesta(out.get("PN_COD_RESULTADO").toString());
            audiResponse.setMensajeRespuesta(out.get("PV_MSG_RESULTADO").toString());
            audiResponse.setFechaTransaccion(header.getFechaTransaccion());
            audiResponse.setIdTransaccion(header.getIdTransaccion());
            response.setAuditResponse(audiResponse);

            if (Integer.parseInt(out.get("PN_COD_RESULTADO").toString()) != EXITOSO) {
                response.setActualizacionSCG(null);
                LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][actualizarSolben][SP_PFC_SU_SOLBEN_ACTUALIZAR][FIN]");
                return response;
            }


            ActualizacionScg actualizacionScg=new ActualizacionScg();
            if (out.get("PV_COD_SCG_SOLBEN") != null)
                actualizacionScg.setCodScgSolben((String) out.get("PV_COD_SCG_SOLBEN"));
            if (out.get("PV_COD_SOL_EVAL") != null)
                actualizacionScg.setCodSolEval((String) out.get("PV_COD_SOL_EVAL"));
            if (out.get("PN_COD_RESULTADO") != null)
                actualizacionScg.setTxDatoAdic1((String) out.get("PV_TX_DATO_ADIC1"));
            if (out.get("PV_MSG_RESULTADO") != null)
                actualizacionScg.setTxDatoAdic2((String) out.get("PV_TX_DATO_ADIC2"));
            if (out.get("PV_TX_DATO_ADIC1") != null)
                actualizacionScg.setTxDatoAdic3((String) out.get("PV_TX_DATO_ADIC3"));

            response.setActualizacionSCG(actualizacionScg);

        } catch (Exception e) {
            LOG.error("[SolbenDaoImpl][actualizarSolben][SP_PFC_SU_SOLBEN_ACTUALIZAR][ERROR]",e);
            audiResponse=new AuditResponse();
            audiResponse.setCodigoRespuesta(COD_ERROR_INTERN_SERVER);
            audiResponse.setMensajeRespuesta(ERROR_INTERNO_DEL_SERVIDOR);
            audiResponse.setIdTransaccion(header.getIdTransaccion());
            audiResponse.setFechaTransaccion(header.getFechaTransaccion());
            response.setActualizacionSCG(null);
        }
        LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][actualizarSolben][SP_PFC_SU_SOLBEN_ACTUALIZAR][FIN]");

        return response;
    }

    @Override
    public  SolbenRegistraCartaGarResponse registrarListaCartaGarantiaSolben(RegistrarCartaGarantiaRequest request, HeaderBean header) {

        Map<String, Object> out;

        final String PROCEDURE = "SP_PAC_I_CARTA_GARANTIA";
        final String CHAR_ARRAY="CHAR_ARRAY";
        final String NUM_ARRAY="NUM_ARRAY";
        AuditResponse audiResponse;
        SolbenRegistraCartaGarResponse response;
        try {

            SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(concurrenciaDataSource)
                    .withSchemaName(ConstanteUtil.ESQUEMA_ONTPAC)
                    .withCatalogName(ConstanteUtil.PAQUETE_SOLBEN_AC)
                    .withProcedureName(PROCEDURE)
                    .withoutProcedureColumnMetaDataAccess()
                    .declareParameters(
                            new SqlParameter("PV_COD_SCG", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_COD_CG", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_COD_CLIN", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_NOMBRE_AFIL", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_COD_AFIL", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_DESC_PLAN", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_COD_DIAG", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_DESC_PROC", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_CMP_MED", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_NOMBRE_MED", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_FEC_HOSP_INI", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_FEC_HOSP_FIN", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_FEC_EMISION_CG", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PV_TIPO_CG", Types.ARRAY, NUM_ARRAY),
                            new SqlParameter("PV_ESTADO_SCG", Types.ARRAY, NUM_ARRAY),
                            new SqlParameter("PV_CLASE_CG", Types.ARRAY, NUM_ARRAY),
                            new SqlParameter("PV_NOMB_VALID", Types.ARRAY, CHAR_ARRAY),
                            new SqlParameter("PN_TOT_PRESUP", Types.ARRAY, NUM_ARRAY));


            MapSqlParameterSource in = new MapSqlParameterSource();

            int arraySize=request.getListaCargaSCG().size();

            String[] codScg=new String[arraySize];
            String[] codCg=new String[arraySize];
            String[] codClinicas=new String[arraySize];
            String[] nombresAfiliados=new String[arraySize];
            String[] codAfiliados=new String[arraySize];
            String[] descPlanes=new String[arraySize];
            String[] codDiagnosticos=new String[arraySize];
            String[] desProcs=new String[arraySize];
            String[] cmpMedicos=new String[arraySize];
            String[] nombreMedicos=new String[arraySize];
            String[] fechaInicio=new String[arraySize];
            String[] fechaFin=new String[arraySize];
            String[] fechaEmisionCg=new String[arraySize];
            Integer[] tipoCg=new Integer[arraySize];
            Integer[] estadoScg=new Integer[arraySize];
            Integer[] claseCg=new Integer[arraySize];
            String[] nombreValidador=new String[arraySize];
            Double[] totalPresupuesto=new Double[arraySize];

            for( int  i=0;i<request.getListaCargaSCG().size();i++){

                codScg[i]=request.getListaCargaSCG().get(i).getCodScgSolben();
                codCg[i] =request.getListaCargaSCG().get(i).getCodCgSolben();
                codClinicas[i]=request.getListaCargaSCG().get(i).getCodClinica();
                nombresAfiliados[i]=request.getListaCargaSCG().get(i).getNombreAfiliado();
                codAfiliados[i]=request.getListaCargaSCG().get(i).getCodAfiPaciente();
                descPlanes[i]=request.getListaCargaSCG().get(i).getDesPlan();
                codDiagnosticos[i]=request.getListaCargaSCG().get(i).getCodDiagnostico();
                desProcs[i]=request.getListaCargaSCG().get(i).getDesProcedimiento();
                cmpMedicos[i]=request.getListaCargaSCG().get(i).getCmpMedico();
                nombreMedicos[i]=request.getListaCargaSCG().get(i).getMedico();
                fechaInicio[i]=request.getListaCargaSCG().get(i).getFecHospInicio();
                fechaFin[i]=request.getListaCargaSCG().get(i).getFecHospFin();
                fechaEmisionCg[i]=request.getListaCargaSCG().get(i).getFecCgSolben();
                tipoCg[i]=request.getListaCargaSCG().get(i).getCodTipoCgSolben();
                estadoScg[i]=request.getListaCargaSCG().get(i).getCodEstadoScg();
                claseCg[i]=request.getListaCargaSCG().get(i).getClaseScg();
                nombreValidador[i]=request.getListaCargaSCG().get(i).getValidadoPor();
                totalPresupuesto[i]=request.getListaCargaSCG().get(i).getTotalPresupuesto();
            }



            SqlTypeValue pvCodScg = createArrayChar(codScg);
            SqlTypeValue pvCodCg = createArrayChar(codCg);
            SqlTypeValue pvCodClin = createArrayChar(codClinicas);
            SqlTypeValue pvNombrAfil = createArrayChar(nombresAfiliados);
            SqlTypeValue pvCodAfil = createArrayChar(codAfiliados);
            SqlTypeValue pvDescPlan = createArrayChar(descPlanes);
            SqlTypeValue pvCodDiag = createArrayChar(codDiagnosticos);
            SqlTypeValue pvDesProc = createArrayChar(desProcs);
            SqlTypeValue pvCmpMed = createArrayChar(cmpMedicos);
            SqlTypeValue pvNomMed = createArrayChar(nombreMedicos);
            SqlTypeValue pvFecHospIni = createArrayChar(fechaInicio);
            SqlTypeValue pvFecHospFin = createArrayChar(fechaFin);
            SqlTypeValue pvFecEmisiCg = createArrayChar(fechaEmisionCg);
            SqlTypeValue pvTipoCg = createArrayInt(tipoCg);
            SqlTypeValue pvEstadoScg = createArrayInt(estadoScg);
            SqlTypeValue pvClaseCg = createArrayInt(claseCg);
            SqlTypeValue pvNombValidador = createArrayChar(nombreValidador);
            SqlTypeValue pvTotalPresupuesto = createArrayDouble(totalPresupuesto);


            in.addValue("PV_COD_SCG",pvCodScg);
            in.addValue("PV_COD_CG", pvCodCg);
            in.addValue("PV_COD_CLIN",pvCodClin);
            in.addValue("PV_NOMBRE_AFIL", pvNombrAfil);
            in.addValue("PV_COD_AFIL",pvCodAfil);
            in.addValue("PV_DESC_PLAN",pvDescPlan);
            in.addValue("PV_COD_DIAG", pvCodDiag);
            in.addValue("PV_DESC_PROC", pvDesProc);
            in.addValue("PV_CMP_MED",pvCmpMed);
            in.addValue("PV_NOMBRE_MED",pvNomMed);
            in.addValue("PV_FEC_HOSP_INI", pvFecHospIni);
            in.addValue("PV_FEC_HOSP_FIN",pvFecHospFin);
            in.addValue("PV_FEC_EMISION_CG", pvFecEmisiCg);
            in.addValue("PV_TIPO_CG",pvTipoCg);
            in.addValue("PV_ESTADO_SCG",pvEstadoScg);
            in.addValue("PV_CLASE_CG", pvClaseCg);
            in.addValue("PV_NOMB_VALID",pvNombValidador);
            in.addValue("PN_TOT_PRESUP", pvTotalPresupuesto);


            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_COD_SCG_SOLBEN", Types.ARRAY,CHAR_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_COD_CG_SOLBEN", Types.ARRAY,CHAR_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_COD_REG_SOLBEN", Types.ARRAY,CHAR_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_FECH_REG_SOLBEN", Types.ARRAY,CHAR_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PN_CODIGO", Types.ARRAY,NUM_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_MENSAJE", Types.ARRAY,CHAR_ARRAY));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PN_CODIGO_TOTAL", Types.NUMERIC));
            simpleJdbcCall.addDeclaredParameter(new SqlOutParameter("PV_MENSAJE_TOTAL", Types.VARCHAR));

            out = simpleJdbcCall.execute(in);


            audiResponse=new AuditResponse();
            audiResponse.setCodigoRespuesta(out.get("PN_CODIGO_TOTAL").toString());
            audiResponse.setMensajeRespuesta((String) out.get("PV_MENSAJE_TOTAL"));
            audiResponse.setIdTransaccion(header.getIdTransaccion());
            audiResponse.setFechaTransaccion(header.getFechaTransaccion());

            response = new SolbenRegistraCartaGarResponse();
            response.setAuditResponse(audiResponse);

            if (Integer.parseInt(out.get("PN_CODIGO_TOTAL").toString()) != EXITOSO) {
                response.setListaRegistroSCG(null);
                LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][registrarListaCartaGarantiaSolben][SP_PAC_I_CARTA_GARANTIA][FIN]");
                return response;
            }

            String[] mensajes = ((String[]) (((ARRAY) (out.get("PV_MENSAJE"))).getArray()));

            List<RegistroSCG> lista=new ArrayList<>();
            for (int j=0;j<mensajes.length;j++){
                RegistroSCG registroSCG=new RegistroSCG();
                registroSCG.setCodCgSolben(((String[])(((ARRAY)(out.get("PV_COD_CG_SOLBEN"))).getArray()))[j]);
                registroSCG.setCodReg(((String[])(((ARRAY)(out.get("PV_COD_REG_SOLBEN"))).getArray()))[j]);
                registroSCG.setCodResultado(((BigDecimal[])(((ARRAY)(out.get("PN_CODIGO"))).getArray()))[j]);
                registroSCG.setCodScgSolben(((String[])(((ARRAY)(out.get("PV_COD_SCG_SOLBEN"))).getArray()))[j]);
                registroSCG.setFecReg(((String[])(((ARRAY)(out.get("PV_FECH_REG_SOLBEN"))).getArray()))[j]);
                registroSCG.setMsgResultado(((String[])(((ARRAY)(out.get("PV_MENSAJE"))).getArray()))[j]);

                lista.add(registroSCG);
            }

            response.setListaRegistroSCG(lista);

        } catch (Exception e) {
            LOG.error("[SolbenDaoImpl][registrarListaCartaGarantiaSolben][ERROR]",e);
            response = new SolbenRegistraCartaGarResponse();
            audiResponse=new AuditResponse();
            audiResponse.setCodigoRespuesta(COD_ERROR_INTERN_SERVER);
            audiResponse.setMensajeRespuesta(ERROR_INTERNO_DEL_SERVIDOR);
            audiResponse.setIdTransaccion(header.getIdTransaccion());
            audiResponse.setFechaTransaccion(header.getFechaTransaccion());
            response.setAuditResponse(audiResponse);
            response.setListaRegistroSCG(null);
        }
        LOG.info("[" + header.getIdTransaccion() + "][SolbenDaoImpl][registrarListaCartaGarantiaSolben][SP_PAC_I_CARTA_GARANTIA][FIN]");
        return response;
    }

    private AbstractSqlTypeValue createArrayDouble(Double[] doubles) {
        return new AbstractSqlTypeValue() {
            protected Object createTypeValue(Connection conn, int sqlType, String typeName) throws SQLException {
                ArrayDescriptor arrayDescriptor = new ArrayDescriptor(typeName, conn);
                return new ARRAY(arrayDescriptor, conn, doubles);
            }
        };
    }

    private AbstractSqlTypeValue createArrayInt(Integer[] integers) {
        return new AbstractSqlTypeValue() {
            protected Object createTypeValue(Connection conn, int sqlType, String typeName) throws SQLException {
                ArrayDescriptor arrayDescriptor = new ArrayDescriptor(typeName, conn);
                return new ARRAY(arrayDescriptor, conn, integers);
            }
        };
    }

    private AbstractSqlTypeValue createArrayChar(String[] strings) {
        return new AbstractSqlTypeValue() {
            protected Object createTypeValue(Connection conn, int sqlType, String typeName) throws SQLException {
                ArrayDescriptor arrayDescriptor = new ArrayDescriptor(typeName, conn);
                return new ARRAY(arrayDescriptor, conn, strings);
            }
        };
    }
}
