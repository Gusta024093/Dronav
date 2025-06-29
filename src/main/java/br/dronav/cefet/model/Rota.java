package br.dronav.cefet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;

@Entity
public class Rota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codRota;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private String pontoInicial;
	@Column(nullable = false, length = 100)
	private String pontoFinal;
	
	public Rota() {
		
	}
	
	public Rota(String nome, String pontoInicial, String pontoFinal) {
		super();
		this.nome = nome;
		this.pontoInicial = pontoInicial;
		this.pontoFinal = pontoFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPontoInicial() {
		return pontoInicial;
	}

	public void setPontoInicial(String pontoInicial) {
		this.pontoInicial = pontoInicial;
	}

	public String getPontoFinal() {
		return pontoFinal;
	}

	public void setPontoFinal(String pontoFinal) {
		this.pontoFinal = pontoFinal;
	}

	public String getCodRota() {
		return codRota;
	}
	
	
	@PostPersist
	private void generateCodRota() {
		String valorIDUnico = String.valueOf(this.id) + LocalDateTime.now().toString();
		this.codRota = "ROTA" + valorIDUnico;
	}
	
	public Long getId() {
		return id;
	}
	
}
