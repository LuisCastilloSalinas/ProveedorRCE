package webservices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import orm.HoraMedica;
import orm.HoraMedicaDAO;
import vo.HoraMedicaRangoVO;

import com.google.gson.Gson;

public class BuscarHoraAPSPorRango {

		
	public String obtenerHoraAPSPorRango(Date fecha1,Date fecha2) {
		String out="";
		
		SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String query ="";
		
		if(fecha1==null || fecha2==null){
			Date fechaHoy = new Date();
            String fecha=formatoFecha.format(fechaHoy);    
			query+="fecha like  "+fecha+" and aps=1 ";
		}
		else {
			if(fecha1.before(fecha2)){
			query+="fecha BETWEEN   '"+formatoFecha.format(fecha1)
					+"'  and  '"+formatoFecha.format(fecha2)+"'  and aps=1 ";
			}
			else{
				if(fecha2.before(fecha1)){
					out+="la fecha 2 debe ser mayor a la primera";
					return out;
				}
				else{
					query+=" fecha like ' % "+fecha1+"%' and aps=1";
				}
			}
		}
		
		try {
			List<HoraMedica> horasMedicas = HoraMedicaDAO.queryHoraMedica(query, null);
			
			
			
			
			Gson gson = new Gson();
			List<HoraMedicaRangoVO> horasMedicaVO = new ArrayList<HoraMedicaRangoVO>();
			
			//se recorre la lista de horas medicas
			//para encontrar las horas medicas no reservadas
			for (HoraMedica horaMedica : horasMedicas) {
				if(horaMedica.reservaid_reserva.isEmpty()){
					horasMedicaVO.add(HoraMedicaRangoVO.getHoraMedicaRangoVO(horaMedica));
				}
				
			}
			
			
				
					

			

			out = gson.toJson(horasMedicaVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return out;
	}
}
