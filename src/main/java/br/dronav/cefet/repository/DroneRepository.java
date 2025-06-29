package br.dronav.cefet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dronav.cefet.model.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {

}

 