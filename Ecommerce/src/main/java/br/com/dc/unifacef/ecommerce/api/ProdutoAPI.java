package br.com.dc.unifacef.ecommerce.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dc.unifacef.ecommerce.entities.Produto;
import br.com.dc.unifacef.ecommerce.repository.ProdutoRepositorio;

// Classe que controla solicitação de API REST
@RestController
// Mapeamento das solicitações
@RequestMapping("/produto")
public class ProdutoAPI {
	
	// Injeção de dependência
	// Usando um objeto de um interface sem instancia-lo
	@Autowired
	private ProdutoRepositorio injecao;
	
	// Metodo GET que retorna uma lista de produtos
	@GetMapping
	public List<Produto> consulta() {
		return injecao.findAll();
	}
	
	// Inserção de produtos no BD
	@PostMapping
	public Produto cadastra(@RequestBody Produto produto) {
		Produto novo = injecao.save(produto);
		return novo;
		
	}

}
