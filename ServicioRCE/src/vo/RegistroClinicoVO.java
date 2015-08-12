package vo;

import orm.RegistroClinico;

public class RegistroClinicoVO {
	private int id;
	private int idHoraMedica;
	private String anamnesis;
	private String alergias;
	private String examenFisico;
	private String  indicacionMedica;
	private String indicacionCierreCaso;
	private String hipotesis;
	private String diagnostico;
	private String detalleGes;
	private String receta;
	private String certificados;
	private String actividades;
	private String procedimientos;
	private String uuidRegistro;
	
	public RegistroClinicoVO(){
		
	}
	
	
	public RegistroClinicoVO(int id, int idHoraMedica, String anamnesis,
			String alergias, String examenFisico, String indicacionMedica,
			String indicacionCierreCaso, String hipotesis, String diagnostico,
			String detalleGes, String receta, String certificados,
			String actividades, String procedimientos, String uuidRegistro) {
		super();
		this.id = id;
		this.idHoraMedica = idHoraMedica;
		this.anamnesis = anamnesis;
		this.alergias = alergias;
		this.examenFisico = examenFisico;
		this.indicacionMedica = indicacionMedica;
		this.indicacionCierreCaso = indicacionCierreCaso;
		this.hipotesis = hipotesis;
		this.diagnostico = diagnostico;
		this.detalleGes = detalleGes;
		this.receta = receta;
		this.certificados = certificados;
		this.actividades = actividades;
		this.procedimientos = procedimientos;
		this.uuidRegistro = uuidRegistro;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHoraMedica() {
		return idHoraMedica;
	}
	public void setIdHoraMedica(int idHoraMedica) {
		this.idHoraMedica = idHoraMedica;
	}
	public String getAnamnesis() {
		return anamnesis;
	}
	public void setAnamnesis(String anamnesis) {
		this.anamnesis = anamnesis;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getExamenFisico() {
		return examenFisico;
	}
	public void setExamenFisico(String examenFisico) {
		this.examenFisico = examenFisico;
	}
	public String getIndicacionMedica() {
		return indicacionMedica;
	}
	public void setIndicacionMedica(String indicacionMedica) {
		this.indicacionMedica = indicacionMedica;
	}
	public String getIndicacionCierreCaso() {
		return indicacionCierreCaso;
	}
	public void setIndicacionCierreCaso(String indicacionCierreCaso) {
		this.indicacionCierreCaso = indicacionCierreCaso;
	}
	public String getHipotesis() {
		return hipotesis;
	}
	public void setHipotesis(String hipotesis) {
		this.hipotesis = hipotesis;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getDetalleGes() {
		return detalleGes;
	}
	public void setDetalleGes(String detalleGes) {
		this.detalleGes = detalleGes;
	}
	public String getReceta() {
		return receta;
	}
	public void setReceta(String receta) {
		this.receta = receta;
	}
	public String getCertificados() {
		return certificados;
	}
	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}
	public String getActividades() {
		return actividades;
	}
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
	public String getProcedimientos() {
		return procedimientos;
	}
	public void setProcedimientos(String procedimientos) {
		this.procedimientos = procedimientos;
	}
	public String getUuidRegistro() {
		return uuidRegistro;
	}
	public void setUuidRegistro(String uuidRegistro) {
		this.uuidRegistro = uuidRegistro;
	}
	
	public static RegistroClinicoVO getRegistroClinicoVO(RegistroClinico registro){
		
		RegistroClinicoVO registroVO = new RegistroClinicoVO();
		registroVO.setId(registro.getId_registro());
		registroVO.setIdHoraMedica(registro.getHora_medicaid_hora_medica().getId_hora_medica());
		registroVO.setAnamnesis(registro.getAnamnesis());
		registroVO.setAlergias(registro.getAlergias());
		registroVO.setExamenFisico(registro.getExamen_fisico());
		registroVO.setIndicacionMedica(registro.getIndicacion_medica());
		registroVO.setIndicacionCierreCaso(registro.getInd_cierre_caso());
		registroVO.setHipotesis(registro.getHipotesis());
		registroVO.setDiagnostico(registro.getDiagnostico());
		registroVO.setDetalleGes(registro.getDetalle_ges());
		registroVO.setReceta(registro.getReceta());
		registroVO.setCertificados(registro.getCertificados());
		registroVO.setActividades(registro.getActividades());
		registroVO.setProcedimientos(registro.getProcedimientos());
		registroVO.setUuidRegistro(registro.getUuid_registro());
		
		return registroVO;
	}
	
	
	
}
