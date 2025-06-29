package br.dronav.cefet.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Rota;
import br.dronav.cefet.repository.RotaRepository;

public class AtualizarRotaForm {
	
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codRota;
	private String nome;
	private String pontoInicial;
	private String pontoFinal;
	
	public AtualizarRotaForm(@NotNull @NotEmpty @Length(min = 3, max = 200) String nome, String pontoInicial, String pontoFinal) {
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

	public Rota update(Long id, RotaRepository rotaRepository) {
		Rota rota = rotaRepository.findById(id).get();
	    rota.setNome(nome);
	    rota.setPontoInicial(pontoInicial);
	    rota.setPontoFinal(pontoFinal);
	    
		return rota;
	}
}