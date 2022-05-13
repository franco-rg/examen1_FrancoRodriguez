package idat.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;
import idat.com.model.MallaCurricular;
import idat.com.repository.MallaRepository;

@Service
public class MallaServiceImpl implements MallaService {

	@Autowired
	public MallaRepository mallaRepository;

	@Override
	public void saveMalla(MallaDTORequest malla) {

		MallaCurricular m = new MallaCurricular();
		m.setIdMalla(malla.getIdMallaDTO());
		m.setAnio(malla.getAnioDTO());
		mallaRepository.save(m);

	}

	@Override
	public void updateMalla(MallaDTORequest malla) {
		MallaCurricular m = new MallaCurricular();
		m.setIdMalla(malla.getIdMallaDTO());
		m.setAnio(malla.getAnioDTO());
		mallaRepository.saveAndFlush(m);
	}

	@Override
	public void deleteMalla(Integer id) {
		mallaRepository.deleteById(id);
	}

	@Override
	public List<MallaDTOResponse> listMalla() {
		List<MallaDTOResponse> lista = new ArrayList<MallaDTOResponse>();
		MallaDTOResponse mDTO = null;

		for (MallaCurricular malla : mallaRepository.findAll()) {
			mDTO = new MallaDTOResponse();
			mDTO.setIdMallaDTO(malla.getIdMalla());
			mDTO.setAnioDTO(malla.getAnio());
			lista.add(mDTO);
		}
		return lista;
	}

	@Override
	public MallaDTOResponse obtenerMallaId(Integer id) {

		MallaCurricular malla = mallaRepository.findById(id).orElse(null);
		MallaDTOResponse mDTO = new MallaDTOResponse();
		mDTO.setIdMallaDTO(malla.getIdMalla());
		mDTO.setAnioDTO(malla.getAnio());
		return mDTO;
	}
}
