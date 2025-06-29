package br.dronav.cefet.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Item;
import br.dronav.cefet.repository.ItemRepository;


public class AtualizarItemForm {
	
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	@NotBlank
	private String codItem;
	@NotBlank
	private String nome;
	@NotBlank
	private Double peso;
	@NotBlank
	private Double altura;
	@NotBlank
	private Double largura;
	@NotBlank
	private Double profundidade;
	
	public AtualizarItemForm(@NotNull @NotEmpty @Length(min = 3, max = 200) String nome, Double peso, Double altura, Double largura, Double profundidade) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public String getCodItem() {
		return codItem;
	}
	
	public Item update(Long id, ItemRepository itemRepository) {
	    Item item = itemRepository.findById(id).get();
	    item.setNome(nome);
	    item.setPeso(peso);
	    item.setLargura(largura);
	    item.setProfundidade(profundidade);
	    item.setProfundidade(profundidade);
		return item;
	}
}
