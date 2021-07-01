package pe.edu.unmsm.sistemas.microservicios.app.cursos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.sistemas.microservicios.app.cursos.clients.AlumnoFeignClient;
import pe.edu.unmsm.sistemas.microservicios.app.cursos.clients.RespuestaFeignClient;
import pe.edu.unmsm.sistemas.microservicios.app.cursos.models.entity.Curso;
import pe.edu.unmsm.sistemas.microservicios.app.cursos.models.repository.CursoRepository;
import pe.edu.unmsm.sistemas.microservicios.commons.alumnos.models.entity.Alumno;
import pe.edu.unmsm.sistemas.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Autowired
	private AlumnoFeignClient clienteAlumno;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
		return client.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
	}

	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids) {
		return clienteAlumno.obtenerAlumnosPorCurso(ids);
	}

	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {
		repository.eliminarCursoAlumnoPorId(id);
	}

}

