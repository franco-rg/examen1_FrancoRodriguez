package idat.com.service;

import java.util.List;

import idat.com.dto.ProfesorDTORequest;
import idat.com.dto.ProfesorDTOResponse;



public interface ProfesorService {
	public void saveProfesor(ProfesorDTORequest profesor);
	public void updateProfesor(ProfesorDTORequest profesor);
	public void deleteProfesor(Integer id);
	public List<ProfesorDTOResponse> listProfesor();
	public ProfesorDTOResponse obtenerProfesorId(Integer id);

}
