package br.com.gio.gi_logistic.service;


import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.StatusEntrega;
import br.com.gio.gi_logistic.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscarEntregaService buscarEntregaService;
    private EntregaRepository entregaRepository;
    @Transactional
    public void finalizar(Integer id){
        Entrega entrega = buscarEntregaService.buscar(id);
        entrega.finalizar();
        entregaRepository.save(entrega);


    }

}
