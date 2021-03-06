package com.qintess.seguradora.cotador.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.seguradora.cotador.dto.SeguradoDto;
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
	public ResponseEntity<?> listaCotador() {
		try {
			return ResponseEntity.ok(seguradoService.findAll());
		} catch (NestedRuntimeException e) {
			String message = e.getRootCause().getMessage();
			return ResponseEntity.internalServerError().body(message + " - " + ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage() + " - " + ExceptionUtils.getStackTrace(e));
		}
	}

	@GetMapping("/segurado/{documento}")
	public ResponseEntity<?> listaCotadorDocumento(@PathVariable(value = "documento") long documento) {
		try {
			return ResponseEntity.ok(seguradoService.findByDocumento(documento));
		} catch (NestedRuntimeException e) {
			String message = e.getRootCause().getMessage();
			return ResponseEntity.internalServerError().body(message + " - " + ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage() + " - " + ExceptionUtils.getStackTrace(e));
		}
	}

	@PostMapping("/segurado")
	public ResponseEntity<?> salvaSegurado(@RequestBody SeguradoDto segurado) {
		try {

			return ResponseEntity.ok(seguradoService.save(segurado));
		} catch (NestedRuntimeException e) {
			String message = e.getRootCause().getMessage();
			return ResponseEntity.internalServerError().body(message + " - " + ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage() + " - " + ExceptionUtils.getStackTrace(e));
		}

	}

	@DeleteMapping("/segurado")
	public ResponseEntity<?> deletaCotador(@RequestBody SeguradoDto seguradoDto) {
		try {
			return ResponseEntity.ok(seguradoService.delete(seguradoDto));
		} catch (NestedRuntimeException e) {
			String message = e.getRootCause().getMessage();
			return ResponseEntity.internalServerError().body(message + " - " + ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage() + " - " + ExceptionUtils.getStackTrace(e));
		}
	}

//criar regra para nao modificar o id, nome e documento.
	// criar um service
	@PutMapping("/segurado")
	public ResponseEntity<?> atualizarSegurado(@RequestBody SeguradoDto seguradoDto) {
		try {
			return ResponseEntity.ok(seguradoService.save(seguradoDto));
		} catch (NestedRuntimeException e) {
			String message = e.getRootCause().getMessage();
			return ResponseEntity.internalServerError().body(message + " - " + ExceptionUtils.getStackTrace(e));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage() + " - " + ExceptionUtils.getStackTrace(e));
		}
	}
}
