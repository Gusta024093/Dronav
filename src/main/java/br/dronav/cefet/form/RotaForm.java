package br.dronav.cefet.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Rota;

public class RotaForm {
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codRota;
	private String nome;
	private String pontoInicial;
	private String pontoFinal;
	
	public RotaForm(String nome, String pontoInicial, String pontoFinal) {
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

	public String getCodRota() {
		return codRota;
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

	public Rota converter() {
		return new Rota(nome, pontoInicial, pontoFinal);
	}
}
