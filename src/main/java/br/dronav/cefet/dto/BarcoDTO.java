package br.dronav.cefet.dto;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dronav.cefet.model.Barco;

public class BarcoDTO {
	private Long id;
	private String nome;
	private Double pesoMaximo;
	private Double volumeMaximo;
	private String codBarco;
	private Double latitude;
	private Double longitude;
	
	public BarcoDTO(Barco barco)
	{
		this.setID(barco.getId());
		this.setcodBarco(barco.getCodBarco());
		this.setNome(barco.getNome());
		this.setPesoMaximo(barco.getPesoMaximo());
		this.setVolumeMaximo(barco.getVolumeMaximo());
		this.setLatitude(barco.getLatitude());
		this.setLongitude(barco.getLongitude());
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	public void setcodBarco(String codBarco) {
		this.codBarco = codBarco;
	}
	
	
	
	public static List<BarcoDTO> converter(List<Barco> listaBanco)
	{
		List<BarcoDTO> bancosDTO = new ArrayList<BarcoDTO>();
		
		for (Iterator<Barco> iterator =  listaBanco.iterator(); iterator.hasNext();) {
			Barco banco = (Barco) iterator.next();
			BarcoDTO bancoDTO = new BarcoDTO(banco);
			
			bancosDTO.add(bancoDTO);
		}
		
		return bancosDTO;
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

	public Long getId() {
		return id;
	}
	
	
}
 