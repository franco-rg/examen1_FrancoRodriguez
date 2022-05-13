package idat.com.service;

import java.util.List;

import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;


public interface MallaService {
	
	public void saveMalla(MallaDTORequest malla);
	public void updateMalla(MallaDTORequest malla);
	public void deleteMalla(Integer id);
	public List<MallaDTOResponse> listMalla();
	public MallaDTOResponse obtenerMallaId(Integer id);

}
