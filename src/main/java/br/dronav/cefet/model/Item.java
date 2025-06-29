package br.dronav.cefet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(nullable = false, length = 100)
	private String codItem;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private Double peso;
	@Column(nullable = false, length = 100)
	private Double altura;
	@Column(nullable = false, length = 100)
	private Double largura;
	@Column(nullable = false, length = 100)
	private Double profundidade;
	
	public Item() {
		
	}
	
	public Item(String nome, Double peso, Double altura, Double largura, Double profundidade, Usuario usuario) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.usuario = usuario;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public String getCodItem() {
		return codItem;
	}

	@PostPersist
	private void generateCodItem() {
		String valorIDUnico = String.valueOf(this.id) + LocalDateTime.now().toString();
		this.codItem = "ITEM" + valorIDUnico;
	}

	public Long getId() {
		return id;
	}
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
	
}
