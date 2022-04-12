package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.model.Cliente;
import br.com.gio.gi_logistic.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    //@PersistenceContext
    // private EntityManager manager;

    private ClienteRepository repository;

    /*@GetMapping("/clientes")
    public List<Cliente> listar(){

        //return manager.createNativeQuery("select * from cliente", Cliente.class).getResultList();

        return repository.findAll();
    }*/

    @GetMapping
    public List<Cliente> listarPorNome() {

        //return manager.createNativeQuery("select * from cliente", Cliente.class).getResultList();

        return repository.findByNomeContaining("novo");
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Integer clienteId) {

        /*Optional<Cliente> cliente = repository.findById(clienteId);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();*/

        return repository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(cliente))
                        .orElse(ResponseEntity.notFound().build());
    }
}
