package br.dronav.cefet.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Usuario;

public class ItemDTO {

	public Long id;
	public String codItem;
	public String nome;
	public Double peso;
	public Double altura;
	public Double largura;
	public Double profundidade;
	private Usuario usuario;
	
	public ItemDTO(Item item)
	{
		this.setID(item.getId());
		this.setcodItem(item.getCodItem());
		this.setNome(item.getNome());
		this.setPeso(item.getPeso());
		this.setAltura(item.getAltura());
		this.setLargura(item.getLargura());
		this.setProfundidade(item.getProfundidade());
		
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	public void setcodItem(String codItem) {
		this.codItem = codItem;
	}

	public static List<ItemDTO> converter(List<Item> listaItem)
	{
		List<ItemDTO> itemsDTO = new ArrayList<ItemDTO>();
		
		for (Iterator<Item> iterator =  listaItem.iterator(); iterator.hasNext();) {
			Item item = (Item) iterator.next();
			ItemDTO itemDTO = new ItemDTO(item);
			itemsDTO.add(itemDTO);
		}
		return itemsDTO;
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
	
	

}
