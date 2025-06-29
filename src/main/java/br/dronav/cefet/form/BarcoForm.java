package br.dronav.cefet.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Barco;


public class BarcoForm {
	
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String nome;
	private String codBarco;
	private Double pesoMaximo;
	private Double volumeMaximo;
	private Double latitude;
	private Double longitude;
	
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
	
	public Barco converter() {
		return new Barco(nome, pesoMaximo, volumeMaximo, latitude, longitude);
	}
	
}
