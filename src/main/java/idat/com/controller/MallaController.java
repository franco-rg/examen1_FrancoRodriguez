package idat.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import idat.com.dto.MallaDTORequest;
import idat.com.dto.MallaDTOResponse;
import idat.com.service.MallaService;

@RestController
@RequestMapping("/malla/api")
public class MallaController {

	@Autowired
	private MallaService mallaService;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaDTOResponse>> listarMalla() {
		return new ResponseEntity<List<MallaDTOResponse>>(mallaService.listMalla(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaDTORequest malla) {
		mallaService.saveMalla(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaDTOResponse> listarPorId(@PathVariable Integer id) {
		MallaDTOResponse mDTO = mallaService.obtenerMallaId(id);
		if (mDTO != null)
			return new ResponseEntity<MallaDTOResponse>(mDTO, HttpStatus.OK);
		return new ResponseEntity<MallaDTOResponse>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaDTORequest malla) {
		MallaDTOResponse mDTO = mallaService.obtenerMallaId(malla.getIdMallaDTO());
		if (mDTO != null) {
			mallaService.updateMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		MallaDTOResponse mDTO = mallaService.obtenerMallaId(id);
		if (mDTO != null) {
			mallaService.deleteMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
