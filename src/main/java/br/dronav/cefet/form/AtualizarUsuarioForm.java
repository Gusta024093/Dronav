package br.dronav.cefet.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import br.dronav.cefet.model.Usuario;
import br.dronav.cefet.repository.UsuarioRepository;

public class AtualizarUsuarioForm {
	
	//@NotNull @NotEmpty @Length(min = 3, max= 200)
	private Long id;
	private String codUsuario;
	private String nomeCompleto;
	private String telefone;
	private String email;
	
	
	public AtualizarUsuarioForm(@NotNull @NotEmpty @Length(min = 3, max= 200) String nomeCompleto, String telefone, String email) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.email = email;
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
	
	public Usuario update(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNomeCompleto(nomeCompleto);
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
		return usuario;
	}
}