package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import com.google.gson.Gson;

import orm.HoraMedica;
import orm.HoraMedicaDAO;
import vo.HoraMedicaVO;

public class BuscarHoraAPSPorMedico {

	public String obtenerHorasAPSPorMedico(int idMedico){
		String out="";
		String consulta="medicoid_medico="+idMedico+"and aps=1";
		try {
			List<HoraMedica> horasMed = HoraMedicaDAO.queryHoraMedica(consulta, null);
			List<HoraMedicaVO>horasMedicasVO = new ArrayList<HoraMedicaVO>();
			for (HoraMedica horaMedica : horasMed) {
				if(horaMedica.reservaid_reserva.isEmpty()){
					horasMedicasVO.add(HoraMedicaVO.getHoraMedicaVO(horaMedica));
				}
			}
			
			Gson gson = new Gson();
			out=gson.toJson(horasMedicasVO);
		
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return out;
	}
}
