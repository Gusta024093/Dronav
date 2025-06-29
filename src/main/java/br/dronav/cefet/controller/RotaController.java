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
import br.dronav.cefet.dto.RotaDTO;
import br.dronav.cefet.form.AtualizarRotaForm;
import br.dronav.cefet.form.RotaForm;
import br.dronav.cefet.model.Item;
import br.dronav.cefet.model.Rota;
import br.dronav.cefet.model.Usuario;
import br.dronav.cefet.repository.RotaRepository;
import io.swagger.annotations.ApiOperation;

//API da Rota
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rotas")
public class RotaController {
	
	@Autowired
	private RotaRepository rotaRepository;
	
	
	@ApiOperation(value = "Retorna uma lista de rotas do banco de dados.")
	@GetMapping
	public List<RotaDTO> rotas()
	{
		List<Rota> tabelaRotas = rotaRepository.findAll();					
		return RotaDTO.converter(tabelaRotas);
	}
	
	@ApiOperation(value = "Cadastra um nova rota no banco de dados.")
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid RotaForm rotaForm,
																		UriComponentsBuilder uriBuilder)
	{
		try {
	        Rota rota = rotaForm.converter();
	        rotaRepository.save(rota);
	        UriComponents uriComponents = uriBuilder.path("/rotas/{id}").buildAndExpand(rota.getId());
	        return ResponseEntity.created(uriComponents.toUri()).body(new RotaDTO(rota));
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
	
	@ApiOperation(value = "Atualiza dados de um rota já cadastrada no banco de dados H2.")
	@PutMapping("/{id}")
	//@Transactional
	public ResponseEntity<RotaDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtualizarRotaForm rotaForm)
	{
		Rota rota = rotaForm.update(id, rotaRepository);
		rotaRepository.save(rota);
		//ok : retorna HTTPStatus = 200
		return ResponseEntity.ok(new RotaDTO(rota));		
	}
	
	@ApiOperation(value = "Deleta uma rota do banco de dados H2.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id)
	{
		rotaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}