package br.dronav.cefet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.dronav.cefet.model.Barco;

public interface BarcoRepository extends JpaRepository<Barco, Long> {

}