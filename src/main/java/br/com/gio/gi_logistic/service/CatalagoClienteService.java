package br.com.gio.gi_logistic.service;

import br.com.gio.gi_logistic.exceptionhandler.NegocioException;
import br.com.gio.gi_logistic.model.Cliente;
import br.com.gio.gi_logistic.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalagoClienteService {

    private ClienteRepository repository;

    @Transactional
    public Cliente salvar(Cliente cliente){

        if (repository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(existe -> !existe.equals(cliente))){

            throw new NegocioException("Email duplicado");
        }


        return repository.save(cliente);
    }

    public void excluir(Integer id){
        repository.deleteById(id);
    }

}
