package br.dronav.cefet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dronav.cefet.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	
}