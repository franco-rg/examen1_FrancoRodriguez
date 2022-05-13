package idat.com.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import idat.com.dto.ProfesorDTORequest;
import idat.com.dto.ProfesorDTOResponse;
import idat.com.model.Profesor;
import idat.com.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	public ProfesorRepository repositorio;
	
	@Override
	public void saveProfesor(ProfesorDTORequest profesor) {
		Profesor p = new Profesor();
		p.setIdProfesor(profesor.getIdProfesorDTO());
		p.setProfesor(profesor.getProfesorDTO());
		repositorio.save(p);
		
	}

	@Override
	public void updateProfesor(ProfesorDTORequest profesor) {
		Profesor p = new Profesor();
		p.setIdProfesor(profesor.getIdProfesorDTO());
		p.setProfesor(profesor.getProfesorDTO());
		repositorio.saveAndFlush(p);
		
	}

	@Override
	public void deleteProfesor(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<ProfesorDTOResponse> listProfesor() {
		List<ProfesorDTOResponse> lista = new ArrayList<ProfesorDTOResponse>();
		ProfesorDTOResponse p = null;
		
		for(Profesor profesor :repositorio.findAll()) {
			p.setIdProfesorDTO(profesor.getIdProfesor());
			p.setProfesorDTO(profesor.getProfesor());
			lista.add(p);
		}
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesorId(Integer id) {
		Profesor profesor = repositorio.findById(id).orElse(null);
		ProfesorDTOResponse p = new ProfesorDTOResponse();
		p.setIdProfesorDTO(profesor.getIdProfesor());
		p.setProfesorDTO(profesor.getProfesor());
		return p;
	}
}
