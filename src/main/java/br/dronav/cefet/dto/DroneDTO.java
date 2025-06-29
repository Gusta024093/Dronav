package br.dronav.cefet.dto;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dronav.cefet.model.Drone;

public class DroneDTO {
	public Long id;
	public String codDrone;
	public Double pesoMaximo;
	public Double volumeMaximo;
	public Double capacidadeBateria;
	
	

	public DroneDTO(Drone drone)
	{
		this.setID(drone.getId());
		this.setcodDrone(drone.getCodDrone());
		this.setPesoMaximo(drone.getPesoMaximo());
		this.setVolumeMaximo(drone.getVolumeMaximo());
		this.setCapacidadeBateria(drone.getCapacidadeBateria());
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	public void setcodDrone(String codDrone) {
		this.codDrone = codDrone;
	}

	public static List<DroneDTO> converter(List<Drone> listaDrone)
	{
	List<DroneDTO> dronesDTO = new ArrayList<DroneDTO>();
	
	for (Iterator<Drone> iterator =  listaDrone.iterator(); iterator.hasNext();) {
		Drone drone = (Drone) iterator.next();
		DroneDTO droneDTO = new DroneDTO(drone);
		
		dronesDTO.add(droneDTO);
	}
	
	return dronesDTO;
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
	
	
	

}
