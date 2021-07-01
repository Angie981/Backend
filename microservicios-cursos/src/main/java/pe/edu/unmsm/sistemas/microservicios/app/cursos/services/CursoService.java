package pe.edu.unmsm.sistemas.microservicios.app.cursos.services;


import pe.edu.unmsm.sistemas.microservicios.app.cursos.models.entity.Curso;
import pe.edu.unmsm.sistemas.microservicios.commons.alumnos.models.entity.Alumno;
import pe.edu.unmsm.sistemas.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	
	public Iterable<Alumno> obtenerAlumnosPorCurso( Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
}
