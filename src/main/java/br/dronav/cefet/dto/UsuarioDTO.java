package br.dronav.cefet.dto;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Usuario;


public class UsuarioDTO {
	
	public Long id;
	
	public String codUsuario;
	public String nomeCompleto;
	public String telefone;
	public String email;
	private String senha;
	private String cpf;
	private List<Item> itens;
	
	public UsuarioDTO(Usuario usuario)
	{
		this.setID(usuario.getId());
		this.setcodUsuario(usuario.getCodUsuario());
		this.setNomeCompleto(usuario.getNomeCompleto());
		this.setTelefone(usuario.getTelefone());
		this.setEmail(usuario.getEmail());
		this.setSenha(usuario.getSenha());
		this.setCpf(usuario.getCpf());
		this.setItens(usuario.getItens());
	}
	
	public void setID(Long id) {
		this.id = id;
	}
	public void setcodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public static List<UsuarioDTO> converter(List<Usuario> listaUsuario)
	{
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for (Iterator<Usuario> iterator =  listaUsuario.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			
			usuariosDTO.add(usuarioDTO);
		}
		
		return usuariosDTO;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	
	public String getTelefone() {
		return telefone;
	}
	
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	
	
	
	
}
