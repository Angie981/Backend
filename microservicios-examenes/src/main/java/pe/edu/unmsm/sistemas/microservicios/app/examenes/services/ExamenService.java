package pe.edu.unmsm.sistemas.microservicios.app.examenes.services;

import java.util.List;

import pe.edu.unmsm.sistemas.microservicios.commons.examenes.models.entity.Asignatura;
import pe.edu.unmsm.sistemas.microservicios.commons.examenes.models.entity.Examen;
import pe.edu.unmsm.sistemas.microservicios.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen>{
	public List<Examen> findByNombre(String term);
	
	public Iterable<Asignatura> findAllAsignaturas();
	
	public Iterable<Long> findExamenesIdsConRespuestasByPreguntaIds(Iterable<Long> preguntaIds);
}