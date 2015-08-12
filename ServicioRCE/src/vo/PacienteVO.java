package vo;

import orm.Paciente;

public class PacienteVO {
	private Integer id;
	private String nombre;
	
	
	public PacienteVO(){}
	public PacienteVO(String nombre, Integer id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public static PacienteVO obtenerPacienteVO (Paciente paciente){
		PacienteVO p = new PacienteVO();
		p.setId(paciente.getId_paciente());
		p.setNombre(paciente.getPersonaid_persona().getNombre());
		return p;
	}
	
}
