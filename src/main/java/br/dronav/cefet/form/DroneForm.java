package br.dronav.cefet.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Drone;


public class DroneForm {
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codDrone;
	private Double pesoMaximo;
	private Double volumeMaximo;
	private Double capacidadeBateria;

	
	public DroneForm(Double pesoMaximo, Double volumeMaximo, Double capacidadeBateria) {
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


	public Drone converter() {
		return new Drone(pesoMaximo, volumeMaximo, capacidadeBateria);
	}


}
