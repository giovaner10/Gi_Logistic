package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.DTO.EntregaModel;
import br.com.gio.gi_logistic.assembler.EntregaAssembler;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.input.EntregaInput;
import br.com.gio.gi_logistic.repository.EntregaRepository;
import br.com.gio.gi_logistic.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {


    private SolicitacaoEntregaService service;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entrega) {

        Entrega novaEntrega = entregaAssembler.toEntity(entrega);

        return service.solicitar(novaEntrega);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Integer id) {


        return service.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EntregaModel> buscar() {


        return entregaAssembler.toCollectionMode(entregaRepository.findAll());
    }


}
