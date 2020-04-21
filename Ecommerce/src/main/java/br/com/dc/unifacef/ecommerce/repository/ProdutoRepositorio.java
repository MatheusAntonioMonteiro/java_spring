package br.com.dc.unifacef.ecommerce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dc.unifacef.ecommerce.entities.Produto;

// Interface para acesso aos métodos de CRUD do Mongo
public interface ProdutoRepositorio extends MongoRepository<Produto, String>{

}
