package pvt.auna.solben.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import pvt.auna.solben.model.bean.SolbenBean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SolbenRowMapper implements RowMapper<SolbenBean> {

	@Override
	public SolbenBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		SolbenBean solbenBean = new SolbenBean();

		solbenBean.setCod_scg_solben(rs.getString("COD_SCG_SOLBEN"));
		solbenBean.setCod_clinica(rs.getString("COD_CLINICA"));
		solbenBean.setCod_afi_paciente(rs.getString("COD_AFI_PACIENTE"));
		solbenBean.setEdad_paciente(rs.getInt("EDAD_PACIENTE"));
		solbenBean.setDes_contratante(rs.getString("DES_CONTRATANTE"));
		solbenBean.setDes_plan(rs.getString("DES_PLAN"));
		solbenBean.setCod_diagnostico(rs.getString("COD_DIAGNOSTICO"));
		solbenBean.setCmp_medico(rs.getString("CMP_MEDICO"));
		solbenBean.setFec_quimio(rs.getString("FEC_QUIMIO"));
		solbenBean.setFec_hosp_inicio(rs.getString("FEC_HOSP_INICIO"));
		solbenBean.setFec_hosp_fin(rs.getString("FEC_HOSP_FIN"));
		solbenBean.setTipo_scg_solben(rs.getString("TIPO_SCG_SOLBEN"));
		solbenBean.setEstado_scg(rs.getString("ESTADO_SCG"));
		solbenBean.setDesc_medicamento(rs.getString("DESC_MEDICAMENTO"));
		solbenBean.setDesc_esquema(rs.getString("DESC_ESQUEMA"));
		solbenBean.setTotal_presupuesto(rs.getDouble("TOTAL_PRESUPUESTO"));
		solbenBean.setDesc_procedimiento(rs.getString("DESC_PROCEDIMIENTO"));
		solbenBean.setPerson_contacto(rs.getString("PERSON_CONTACTO"));
		solbenBean.setObs_clinica(rs.getString("OBS_CLINICA"));
		solbenBean.setInd_valida(rs.getInt("IND_VALIDA"));
		solbenBean.setFec_scg_solben(rs.getString("FEC_SCG_SOLBEN"));
		solbenBean.setHora_scg_solben(rs.getString("HORA_SCG_SOLBEN"));
		// solbenBean.setTx_dato_adic1(rs.getString("TX_DATO_ADIC1"));
		// solbenBean.setTx_dato_adic2(rs.getString("TX_DATO_ADIC2"));
		// solbenBean.setTx_dato_adic3(rs.getString("TX_DATO_ADIC3"));
		solbenBean.setFec_receta(rs.getString("FEC_RECETA"));
		solbenBean.setMedico_tratante_prescriptor(rs.getString("MEDICO_TRATANTE_PRESCRIPTOR"));
		solbenBean.setFec_afiliacion(rs.getString("FEC_AFILIACION"));

		return solbenBean;
	}
}
