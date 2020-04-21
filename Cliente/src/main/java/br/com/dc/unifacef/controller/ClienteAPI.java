package br.com.dc.unifacef.controller;

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

import br.com.dc.unifacef.dto.ClienteDTO;
import br.com.dc.unifacef.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/clientes")
public class ClienteAPI {
	
	// Injeção de dependencia
	// Usar um objeto sem ter qur instancia-lo
	@Autowired
	private ClienteRepositorio repositorio;
	
	// Metodo GET
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> consulta(){
		return ResponseEntity.ok(repositorio.findAll());
	}
	
	// Metodo POST
	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO clienteDTO){
		repositorio.save(clienteDTO);
		return ResponseEntity.ok(clienteDTO);
	}
	
	// Metodo PUT
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> atualizacao(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
		clienteDTO.setId(id);
		repositorio.save(clienteDTO);
		return ResponseEntity.ok(clienteDTO);
	}
	
	// Metodo DELETE
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> deletar(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
		clienteDTO.setId(id);
		repositorio.delete(clienteDTO);
		return ResponseEntity.ok(clienteDTO);
	}
}
