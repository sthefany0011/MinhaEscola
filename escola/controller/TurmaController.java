package com.MinhaEscola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MinhaEscola.escola.model.Turma;
import com.MinhaEscola.escola.repository.TurmaRepository;



@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class TurmaController {
	@Autowired
	private TurmaRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<Turma>>GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}
	
	
	@GetMapping("/{id")
	public ResponseEntity<Turma>GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
}
