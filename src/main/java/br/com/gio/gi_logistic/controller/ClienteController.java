package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.model.Cliente;
import br.com.gio.gi_logistic.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listar() {

        //return manager.createNativeQuery("select * from cliente", Cliente.class).getResultList();

        //return repository.findByNomeContaining("novo");
        return repository.findAll();
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

        return repository.save(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> atualizar(@Valid @PathVariable Integer id, @RequestBody Cliente cliente) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(id);
        Cliente save = repository.save(cliente);

        return ResponseEntity.ok(save);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Integer id){
        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
