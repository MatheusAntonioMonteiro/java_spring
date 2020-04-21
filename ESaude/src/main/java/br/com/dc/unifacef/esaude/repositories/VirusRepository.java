package br.com.dc.unifacef.esaude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dc.unifacef.esaude.entities.Virus;

public interface VirusRepository  extends JpaRepository<Virus, Long>{
	
	

}
