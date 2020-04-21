package br.com.dc.unifacef.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dc.unifacef.dto.ClienteDTO;

public interface ClienteRepositorio extends JpaRepository<ClienteDTO, Long>{

}
