package br.dronav.cefet.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codUsuario;
	@Column(nullable = false, length = 100)
	private String nomeCompleto;
	@Column(nullable = false, length = 100)
	private String telefone;
    @Column(nullable = false, length = 11, unique = true)
	private String cpf;
    @Column(nullable = false, length = 100, unique = true)
	private String email;
	@Column(nullable = false, length = 100)
	private String senha;
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeCompleto, String telefone, String email, String cpf, String senha, List<Item> itens) {
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

	public Long getId() {
		return id;
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	@PostPersist
	private void generateCodUsuario() {
		String valorIDUnico = String.valueOf(this.id) + LocalDateTime.now().toString();
		this.codUsuario = "UID" + valorIDUnico;
	}
	
	@PrePersist
    public void prePersist() {
        this.senha = new BCryptPasswordEncoder().encode(this.senha);
    }
	
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Item> itens;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
    
    
	
}
