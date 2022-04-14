package br.com.gio.gi_logistic.repository;

import br.com.gio.gi_logistic.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);
}
