package br.dronav.cefet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;

@Entity
public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(nullable = false, length = 100)
	private String codDrone;
	@Column(nullable = false, length = 100)
	private Double pesoMaximo;
	@Column(nullable = false, length = 100)
	private Double volumeMaximo;
	@Column(nullable = false, length = 100)
	private Double capacidadeBateria;

	public Drone() {
		
	}
	
	public Drone(Double pesoMaximo, Double volumeMaximo, Double capacidadeBateria) {
		super();
		this.pesoMaximo = pesoMaximo;
		this.volumeMaximo = volumeMaximo;
		this.capacidadeBateria = capacidadeBateria;
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
	public Double getCapacidadeBateria() {
		return capacidadeBateria;
	}
	
	public void setCapacidadeBateria(Double capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}
	
	public String getCodDrone() {
		return codDrone;
	}
	
	@PostPersist
	private void generateCodDrone() {
		String valorIDUnico = String.valueOf(this.id) + LocalDateTime.now().toString();
		this.codDrone = "DRN" + valorIDUnico;
	}
	
	public Long getId() {
		return id;
	}
}
