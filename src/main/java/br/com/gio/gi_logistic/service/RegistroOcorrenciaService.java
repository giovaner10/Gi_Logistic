package br.com.gio.gi_logistic.service;

import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscarEntregaService BuscarEntregaService;

    @Transactional
    public Ocorrencia registrar(Integer entregaId, String descricao){
        Entrega entrega = BuscarEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrencia(descricao);
    }
}
