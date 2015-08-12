package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import com.google.gson.Gson;

import orm.Paciente;
import orm.PacienteDAO;
import vo.PacienteVO;

public class PacientesWS {

	public String obtenerPacientes() {
		String out = "";

		try {
			List<Paciente> pacientes = PacienteDAO.queryPaciente(null, null);

			List<PacienteVO> pacientesVO = new ArrayList<PacienteVO>();

			for (Paciente paciente : pacientes) {
				pacientesVO.add(PacienteVO.obtenerPacienteVO(paciente));
			}
			
			Gson gson = new Gson();
			out=gson.toJson(pacientesVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}
}
