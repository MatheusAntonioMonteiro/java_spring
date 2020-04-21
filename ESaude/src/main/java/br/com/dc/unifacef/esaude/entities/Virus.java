package br.com.dc.unifacef.esaude.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="virus") // A classe é mapeado para a table virus no banco de dados
public class Virus implements Serializable {
	
	/**
	 * Garante que o objeto origem e fim são os mesmos
	 */
	private static final long serialVersionUID = -8990951583266207692L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="letalidade")
	private float letalidade;
	
	@Column(name="origem")
	private String origem;
	
	public Virus() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getLetalidade() {
		return letalidade;
	}

	public void setLetalidade(float letalidade) {
		this.letalidade = letalidade;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Virus [id=" + id + ", nome=" + nome + ", letalidade=" + letalidade + ", origem=" + origem + "]";
	}
	
	
	
}
