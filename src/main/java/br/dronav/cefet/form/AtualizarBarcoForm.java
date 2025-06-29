package br.dronav.cefet.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Barco;
import br.dronav.cefet.repository.BarcoRepository;



public class AtualizarBarcoForm {

	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String nome;
	private String codBarco;

	private Double pesoMaximo;

	private Double volumeMaximo;

	private Double latitude;

	private Double longitude;
	
	public AtualizarBarcoForm(@NotNull @NotEmpty @Length(min = 3, max = 200) String nome, Double pesoMaximo,
		Double volumeMaximo, Double latitude, Double longitude) {
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
	public Barco update(Long id, BarcoRepository barcoRepository) {
	    Barco barco = barcoRepository.findById(id).get();
		barco.setNome(nome);
		barco.setPesoMaximo(pesoMaximo);
		barco.setVolumeMaximo(volumeMaximo);
		barco.setLatitude(latitude);
		barco.setLongitude(longitude);
		return barco;
	}
}
