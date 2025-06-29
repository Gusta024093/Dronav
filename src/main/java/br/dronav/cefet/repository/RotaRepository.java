package br.dronav.cefet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.dronav.cefet.model.Rota;

public interface RotaRepository extends JpaRepository<Rota, Long> {

}