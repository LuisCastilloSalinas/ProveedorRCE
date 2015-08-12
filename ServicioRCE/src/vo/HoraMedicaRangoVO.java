package vo;

import java.util.Date;

import orm.HoraMedica;

public class HoraMedicaRangoVO {

	private int id;
	private Date fecha;
	private String nombreMedico;
	
	public HoraMedicaRangoVO() {
		// TODO Auto-generated constructor stub
	}
	
	public HoraMedicaRangoVO(int id, Date fecha, String nMedico) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.nombreMedico=nMedico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

	public String getnMedico() {
		return nombreMedico;
	}

	public void setnMedico(String nMedico) {
		this.nombreMedico = nMedico;
	}

	public static HoraMedicaRangoVO getHoraMedicaRangoVO(HoraMedica horaMedica) {
		
		HoraMedicaRangoVO horaMedicaVO = new HoraMedicaRangoVO();
		horaMedicaVO.setId(horaMedica.getId_hora_medica());
		horaMedicaVO.setFecha(horaMedica.getFecha());
		horaMedicaVO.setnMedico(horaMedica.getMedicoid_medico().getPersonaid_persona().getNombre());
		return horaMedicaVO;
	}
	
	
}
