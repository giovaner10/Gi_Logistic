package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/cli")
    public List<Cliente> listar(){

        return manager.createNativeQuery("select * from cliente", Cliente.class).getResultList();

    }
}
