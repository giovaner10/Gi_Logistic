package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {



    private SolicitacaoEntregaService service;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega) {


        return service.solicitar(entrega);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Entrega> buscar(@PathVariable Integer id) {


        return service.findById(id);
    }




}
