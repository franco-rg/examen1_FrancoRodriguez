package idat.com.service;

import java.util.List;
import idat.com.dto.CursoDTORequest;
import idat.com.dto.CursoDTOResponse;

public interface CursoService {

	public void saveCurso(CursoDTORequest curso);
	public void updateCurso(CursoDTORequest curso);
	public void deleteCurso(Integer id);
	public List<CursoDTOResponse> listCursos();
	public CursoDTOResponse obtenerCursoId(Integer id);
}
