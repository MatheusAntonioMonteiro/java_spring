package br.com.dc.unifacef.esaude.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dc.unifacef.esaude.entities.Virus;
import br.com.dc.unifacef.esaude.exception.ResourceNotFoundException;
import br.com.dc.unifacef.esaude.repositories.VirusRepository;

@RestController
public class VirusController {
	
	// Injeção de dependência
	@Autowired
	private VirusRepository injecao;
	
	@GetMapping("/api/virus")
	public List<Virus> consulta() {
		
		return injecao.findAll();
		
	}
	
	@PostMapping("/api/virus")
	public Virus insere(@Valid @RequestBody Virus virus) {
		
		return injecao.save(virus);
		
	}
	
	@PutMapping("/api/virus/{id}")
	public Virus atualiza(@PathVariable Long id, 
						  @Valid @RequestBody Virus virusRequest) {
		
		return injecao.findById(id)
				.map(virus -> {
					virus.setNome(virusRequest.getNome());
					virus.setLetalidade(virusRequest.getLetalidade());
					virus.setOrigem(virusRequest.getOrigem());
					
					return injecao.save(virus);
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));// atualiza
	}
	
	@DeleteMapping("/api/virus/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return injecao.findById(id)
				.map(virus -> {
					
					injecao.delete(virus);
					
					return ResponseEntity.ok().build();
					
				}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
			
	}
	
}
