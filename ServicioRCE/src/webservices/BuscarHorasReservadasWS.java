package webservices;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import orm.HoraMedica;
import orm.HoraMedicaCriteria;
import orm.HoraMedicaDAO;
import orm.RegistroClinicoCriteria;
import vo.HoraMedicaVO;

import com.google.gson.Gson;

public class BuscarHorasReservadasWS {
	
	public String buscarHorasReservadas( Date fecha1, int idMedico){
		
		String out="";
		SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
		
		String query ="";  
	//	query+="medicoid_medico="+idMedico+" and fecha like '%"+formatoFecha.format(fecha1)+"%'and aps=1";
		query= "fecha like '%"+formatoFecha.format(fecha1)+"%'";
		query+="and medicoid_medico="+idMedico+"";
		query+="and aps=1";
		
		
		try {
			List<HoraMedica> horasMed = HoraMedicaDAO.queryHoraMedica(query, null);
			List<HoraMedicaVO>horasMedicasVO = new ArrayList<HoraMedicaVO>();
			for (HoraMedica horaMedica : horasMed) {
				if(!horaMedica.reservaid_reserva.isEmpty()){
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
