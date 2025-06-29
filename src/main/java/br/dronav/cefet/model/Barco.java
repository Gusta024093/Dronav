package br.dronav.cefet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;


@Entity
public class Barco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(nullable = false, length = 100)
	private String codBarco;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private Double pesoMaximo;
	@Column(nullable = false, length = 100)
	private Double volumeMaximo;
	@Column(nullable = false, length = 100)
	private Double latitude;
	@Column(nullable = false, length = 100)
	private Double longitude;
	
	public Barco() {
		
	}

	public Barco(String nome, Double pesoMaximo, Double volumeMaximo, Double latitude, Double longitude) {
		super();
		this.nome = nome;
		this.pesoMaximo = pesoMaximo;
		this.volumeMaximo = volumeMaximo;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public Double getVolumeMaximo() {
		return volumeMaximo;
	}

	public void setVolumeMaximo(Double volumeMaximo) {
		this.volumeMaximo = volumeMaximo;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getCodBarco() {
		return codBarco;
	}
	
	@PostPersist
	private void generateCodBarco() {
		String valorIDUnico = String.valueOf(this.id) + LocalDateTime.now().toString();
		this.codBarco = "BAR" + valorIDUnico;
	}

	public Long getId() {
		return id;
	}
}
