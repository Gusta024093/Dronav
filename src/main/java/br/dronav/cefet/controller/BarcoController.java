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

import br.dronav.cefet.dto.BarcoDTO;
import br.dronav.cefet.dto.ItemDTO;
import br.dronav.cefet.form.AtualizarBarcoForm;
import br.dronav.cefet.form.BarcoForm;
import br.dronav.cefet.model.Barco;
import br.dronav.cefet.model.Item;
import br.dronav.cefet.repository.BarcoRepository;
import io.swagger.annotations.ApiOperation;

//API do Barco
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/barcos")
public class BarcoController {
	
	@Autowired
	private BarcoRepository barcoRepository;
	
	
	@ApiOperation(value = "Retorna uma lista de barcos do banco de dados H2.")
	@GetMapping
	public List<BarcoDTO> barcos()
	{
		List<Barco> tabelaBarcos = barcoRepository.findAll();					
		return BarcoDTO.converter(tabelaBarcos);
	}
	
	@ApiOperation(value = "Cadastra um novo barco no banco de dados H2.")
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid BarcoForm barcoForm,
																		UriComponentsBuilder uriBuilder)
	{
		try {
	        Barco barco = barcoForm.converter();
	        barcoRepository.save(barco);
	        UriComponents uriComponents = uriBuilder.path("/itens/{id}").buildAndExpand(barco.getId());
	        return ResponseEntity.created(uriComponents.toUri()).body(new BarcoDTO(barco));
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
	
	@ApiOperation(value = "Atualiza dados de um barco já cadastrado no banco de dados H2.")
	@PutMapping("/{id}")
	//@Transactional
	public ResponseEntity<BarcoDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtualizarBarcoForm barcoForm)
	{
		Barco  barco = barcoForm.update(id, barcoRepository);
		barcoRepository.save(barco);
		//ok : retorna HTTPStatus = 200
		return ResponseEntity.ok(new BarcoDTO(barco));		
	}
	
	@ApiOperation(value = "Deleta um barco do banco de dados.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id)
	{
		barcoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}