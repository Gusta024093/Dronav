package br.dronav.cefet.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Usuario;

public class ItemForm{
	
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codItem;
	private String nome;
	private Double peso;
	private Double altura;
	private Double largura;
	private Double profundidade;
	private Usuario usuario;
	
	public ItemForm(String nome, Double peso, Double altura, Double largura, Double profundidade, Usuario usuario) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
		this.usuario = usuario;
		
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
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Item converter() {
		return new Item(nome, peso, altura, largura, profundidade, usuario);
	}
}
