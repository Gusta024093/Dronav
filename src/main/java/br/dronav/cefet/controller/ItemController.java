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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.dronav.cefet.dto.ItemDTO;
import br.dronav.cefet.form.AtualizarItemForm;
import br.dronav.cefet.form.ItemForm;
import br.dronav.cefet.model.Item;
import br.dronav.cefet.repository.ItemRepository;
import io.swagger.annotations.ApiOperation;

//API do Item
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itens")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@ApiOperation(value = "Retorna uma lista de itens do banco de dados H2.")
	@GetMapping
	public List<ItemDTO> itens()
	{
		List<Item> tabelaItens = itemRepository.findAll();					
		return ItemDTO.converter(tabelaItens);
	}
	
	@ApiOperation(value = "Cadastra um novo item no banco de dados H2.")
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ItemForm itemForm,
																		UriComponentsBuilder uriBuilder)
	{
		try {
	        Item item = itemForm.converter();
	        itemRepository.save(item);
	        UriComponents uriComponents = uriBuilder.path("/itens/{id}").buildAndExpand(item.getId());
	        return ResponseEntity.created(uriComponents.toUri()).body(new ItemDTO(item));
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
	
	@ApiOperation(value = "Atualiza dados de um item já cadastrado no banco de dados H2.")
	@PutMapping("/{id}")
	//@Transactional
	public ResponseEntity<ItemDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtualizarItemForm itemForm)
	{
		Item item = itemForm.update(id, itemRepository);
		itemRepository.save(item);
		//ok : retorna HTTPStatus = 200
		return ResponseEntity.ok(new ItemDTO(item));		
	}
	
	@ApiOperation(value = "Deleta um item do banco de dados H2.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id)
	{
		itemRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}