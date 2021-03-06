package br.com.gio.gi_logistic.controller;

import br.com.gio.gi_logistic.assembler.OcorrenciaAssembler;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.Ocorrencia;
import br.com.gio.gi_logistic.model.input.OcorrenciaInput;
import br.com.gio.gi_logistic.model.input.OcorrenciaModel;
import br.com.gio.gi_logistic.service.BuscarEntregaService;
import br.com.gio.gi_logistic.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;
    private BuscarEntregaService buscarEntregaService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Integer entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toEntity(ocorrenciaRegistrada);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OcorrenciaModel> Listar(@PathVariable Integer entregaId){

        Entrega entrega  = buscarEntregaService.buscar(entregaId);

        return  ocorrenciaAssembler.toList(entrega.getOcorrencias());
    }
}
