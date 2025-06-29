package br.dronav.cefet.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Drone;
import br.dronav.cefet.repository.DroneRepository;

public class AtualizarDroneForm {
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codDrone;
	private Double pesoMaximo;
	private Double volumeMaximo;
	private Double capacidadeBateria;
	
	public AtualizarDroneForm(@NotNull @NotEmpty @Length(min = 3, max = 200) Double pesoMaximo,Double volumeMaximo, Double capacidadeBateria){
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


	public Drone update(Long id, DroneRepository droneRepository) {
		Drone drone = droneRepository.findById(id).get();
		drone.setPesoMaximo(pesoMaximo);
		drone.setVolumeMaximo(volumeMaximo);
		drone.setCapacidadeBateria(capacidadeBateria);
		
		return drone;
	}
}
