package com.qintess.seguradora.cotador.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.seguradora.cotador.model.Segurado;
import com.qintess.seguradora.cotador.repository.CotadorRepository;



@RestController
@RequestMapping(value = "/api")
public class CotadorResource {

	@Autowired
	CotadorRepository cotadorRepository;

	@GetMapping("/cotador")
	public List<Segurado> listaCotador() {
		return cotadorRepository.findAll();
	}

	@GetMapping("/cotador/{id}")
	public Segurado listaCotadorid(@PathVariable(value = "id") long id) {
		return cotadorRepository.findById(id);
	}

	@PostMapping("/cotador")
	public Segurado salvaCotador(@RequestBody Segurado cotador) {
		return cotadorRepository.save(cotador);
	}

	@DeleteMapping("/cotador")
	public void deletaCotador(@RequestBody Segurado cotador) {
		cotadorRepository.delete(cotador);
	}

	@PutMapping("/cotador")
	public Segurado atualizarCotador(@RequestBody Segurado cotador) {
		return cotadorRepository.save(cotador);

	}
}


