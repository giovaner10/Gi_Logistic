package br.com.gio.gi_logistic.repository;

import br.com.gio.gi_logistic.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {


}
