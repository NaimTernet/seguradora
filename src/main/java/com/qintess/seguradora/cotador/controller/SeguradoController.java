package com.qintess.seguradora.cotador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.model.SeguradoTelefone;
import com.qintess.seguradora.cotador.repository.SeguradoRepository;
import com.qintess.seguradora.cotador.service.SeguradoService;

@RestController
@RequestMapping(value = "/api")
public class SeguradoController {

	@Autowired
	SeguradoRepository seguradoRepository;
	@Autowired
	SeguradoService seguradoService;

	@GetMapping("/segurado")
	public List<Segurado> listaCotador() {
		return seguradoService.findAll();
	}

	@GetMapping("/segurado/{documento}")
	public List<Segurado> listaCotadorDocumento(@PathVariable(value = "documento") long documento) {
		return seguradoRepository.findBydocumento(documento);
	}

	@PostMapping("/segurado")
	public ResponseEntity<?> salvaSegurado(@RequestBody Segurado segurado) {
		return ResponseEntity.ok(seguradoRepository.save(segurado));
	}

	@DeleteMapping("/segurado")
	public void deletaCotador(@RequestBody Segurado segurado) {
		seguradoRepository.delete(segurado);
	}

//criar regra para nao modificar o id, nome e documento.
	// criar um service
	@PutMapping("/segurado")
	public Segurado atualizarSegurado(@RequestBody Segurado segurado) {
		// substituir pelo Service
		return seguradoRepository.save(segurado);

	}
}
