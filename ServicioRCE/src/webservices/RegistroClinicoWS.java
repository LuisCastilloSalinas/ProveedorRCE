package webservices;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

import orm.HoraMedica;
import orm.HoraMedicaCriteria;
import orm.HoraMedicaDAO;
import orm.PacienteCriteria;
import orm.PersonaCriteria;
import orm.RegistroClinico;
import orm.RegistroClinicoCriteria;
import orm.RegistroClinicoDAO;
import orm.ReservaCriteria;
import vo.RegistroClinicoVO;

import com.google.gson.Gson;

public class RegistroClinicoWS {

	/**
	 * Metodo que obtiene todos los registros clinicos
	 * 
	 * @return
	 */
	public String getRegistroClinico() {
		String out = "";
		try {
			List<RegistroClinico> registros = RegistroClinicoDAO
					.queryRegistroClinico(null, null);
			List<RegistroClinicoVO> registrosVO = new ArrayList<RegistroClinicoVO>();

			for (RegistroClinico registroClinico : registros) {
				registrosVO.add(RegistroClinicoVO
						.getRegistroClinicoVO(registroClinico));
			}

			Gson gson = new Gson();
			out = gson.toJson(registrosVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}

	/**
	 * MEtodo que busca el registro clinico por el nombre de la persona
	 * 
	 * @param nombre
	 * @return
	 */
	public String getRegistroClinicoPorNombre(String nombre) {
		String out = "";
		try {
			RegistroClinicoCriteria rc = new RegistroClinicoCriteria();
			HoraMedicaCriteria hm = rc
					.createHora_medicaid_hora_medicaCriteria();
			ReservaCriteria resC = hm.createReservaid_reservaCriteria();
			PacienteCriteria pc = resC.createPacienteid_pacienteCriteria();
			PersonaCriteria per = pc.createPersonaid_personaCriteria();
			per.nombre.eq(nombre);
			List<RegistroClinico> registro = rc.list();

			List<RegistroClinicoVO> registrosVO = new ArrayList<RegistroClinicoVO>();

			for (RegistroClinico registroClinico : registro) {
				registrosVO.add(RegistroClinicoVO
						.getRegistroClinicoVO(registroClinico));
			}

			Gson gson = new Gson();
			out = gson.toJson(registrosVO);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}

	public String crearRegistroClinico(int idHora, String anamnesis,
			String alergias, String examenFisico, String indicacionMedica,
			String indicacionCierreCaso, String hipotesis, String diagnostico,
			String detalleGes, String receta, String certificados,
			String actividades, String procedimientos) {
		
		
		String out = "";
		
		try {
			RegistroClinicoCriteria re = new RegistroClinicoCriteria();
			re.hora_medicaid_hora_medicaId.eq(idHora);
			if(re.list().size()<=0){
			
			
			HoraMedica h = HoraMedicaDAO.getHoraMedicaByORMID(idHora);
			RegistroClinico rc = new RegistroClinico();
			rc.setHora_medicaid_hora_medica(h);
			rc.setAnamnesis(anamnesis);
			rc.setAlergias(alergias);
			rc.setExamen_fisico(examenFisico);
			rc.setIndicacion_medica(indicacionMedica);
			rc.setInd_cierre_caso(indicacionCierreCaso);
			rc.setHipotesis(hipotesis);
			rc.setDiagnostico(diagnostico);
			rc.setDetalle_ges(detalleGes);
			rc.setReceta(receta);
			rc.setCertificados(certificados);
			rc.setActividades(actividades);
			rc.setProcedimientos(procedimientos);
			rc.setUuid_registro(java.util.UUID.randomUUID().toString());
			
			RegistroClinicoDAO.save(rc);
			}
			else{
				return "Hora Médica Posee Registro Clinico";
			}
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out+="Registro Ingresado Correctamente";
		return out;
	}
}
