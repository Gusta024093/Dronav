package br.dronav.cefet.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.dronav.cefet.dto.ItemDTO;
import br.dronav.cefet.dto.UsuarioDTO;
import br.dronav.cefet.form.AtualizarUsuarioForm;
import br.dronav.cefet.form.UsuarioForm;
import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Usuario;
import br.dronav.cefet.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

//API do Usuario
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@ApiOperation(value = "Retorna uma lista de usuarios do banco de dados H2.")
	@GetMapping
	public List<UsuarioDTO> usuarios()
	{
		List<Usuario> tabelaUsuarios = usuarioRepository.findAll();					
		return UsuarioDTO.converter(tabelaUsuarios);
	}
	
	@ApiOperation(value = "Cadastra um novo usuário no banco de dados H2.")
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm,
																		UriComponentsBuilder uriBuilder)
	{
		try {
	        Usuario usuario = usuarioForm.converter();
	        usuarioRepository.save(usuario);
	        UriComponents uriComponents = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId());
	        return ResponseEntity.created(uriComponents.toUri()).body(new UsuarioDTO(usuario));
	    } catch (DataIntegrityViolationException e) {
	        // Tratar exceção de violação de integridade (por exemplo, registro duplicado)
	    	String mensagem = "Tentativa Inválida de violação de integridade no registro";
	        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(mensagem);
	    
	    } 
		catch (Exception e) {
	    	String mensagem = "Ocorreu um erro interno ao processar a solicitação";
	        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.TEXT_PLAIN).body(mensagem);
	    }
		
	}
	
	@ApiOperation(value = "Atualiza dados de um usuário já cadastrado no banco de dados.")
	@PutMapping("/{id}")
	//@Transactional
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtualizarUsuarioForm usuarioForm)
	{
		Usuario usuario = usuarioForm.update(id, usuarioRepository);
		usuarioRepository.save(usuario);
		//ok : retorna HTTPStatus = 200
		return ResponseEntity.ok(new UsuarioDTO(usuario));		
	}
	
	@ApiOperation(value = "Deleta um usuário do banco de dados.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id)
	{
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}	
}