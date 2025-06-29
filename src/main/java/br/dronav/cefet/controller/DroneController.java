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

import br.dronav.cefet.dto.DroneDTO;
import br.dronav.cefet.dto.ItemDTO;
import br.dronav.cefet.form.AtualizarDroneForm;
import br.dronav.cefet.form.DroneForm;
import br.dronav.cefet.model.Drone;
import br.dronav.cefet.model.Item;
import br.dronav.cefet.repository.DroneRepository;
import io.swagger.annotations.ApiOperation;

//API do Drone
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/drones")
public class DroneController {
	
	@Autowired
	private DroneRepository droneRepository;
	
	
	@ApiOperation(value = "Retorna uma lista de drones do banco de dados H2.")
	@GetMapping
	public List<DroneDTO> drones()
	{
		List<Drone> tabelaDrones = droneRepository.findAll();					
		return DroneDTO.converter(tabelaDrones);
	}
	
	@ApiOperation(value = "Cadastra um novo drone no banco de dados H2.")
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid DroneForm droneForm,
																		UriComponentsBuilder uriBuilder)
	{
		try {
	        Drone drone = droneForm.converter();
	        droneRepository.save(drone);
	        UriComponents uriComponents = uriBuilder.path("/itens/{id}").buildAndExpand(drone.getId());
	        return ResponseEntity.created(uriComponents.toUri()).body(new DroneDTO(drone));
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
	
	@ApiOperation(value = "Atualiza dados de um dorne já cadastrado no banco de dados H2.")
	@PutMapping("/{id}")
	//@Transactional
	public ResponseEntity<DroneDTO> atualizar(@PathVariable Long id, 
			@RequestBody @Valid AtualizarDroneForm droneForm)
	{
		Drone drone = droneForm.update(id, droneRepository);
		droneRepository.save(drone);
		//ok : retorna HTTPStatus = 200
		return ResponseEntity.ok(new DroneDTO(drone));		
	}
	
	@ApiOperation(value = "Deleta um drone do banco de dados.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id)
	{
		droneRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}