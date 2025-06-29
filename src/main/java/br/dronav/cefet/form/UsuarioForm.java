package br.dronav.cefet.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Usuario;

public class UsuarioForm {

	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codUsuario;
	private String nomeCompleto;
	private String telefone;
	private String email;
	private String cpf;
	private String senha;
	private List<Item> itens;

	public UsuarioForm(String nomeCompleto, String telefone, String email, String cpf, String senha, List<Item> itens) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.itens = itens;
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
	
	
	
	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}
	
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Usuario converter() {
		return new Usuario(nomeCompleto, telefone, email, cpf, senha, itens);
	}
}
