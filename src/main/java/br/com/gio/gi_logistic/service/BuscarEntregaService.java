package br.com.gio.gi_logistic.service;


import br.com.gio.gi_logistic.exceptionhandler.NegocioException;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarEntregaService {

    private EntregaRepository entregaRepository;


    public Entrega buscar(Integer id){
        return entregaRepository.findById(id)
                .orElseThrow(()-> new NegocioException("Não foi possivel, pois essa entrega nao existe"));

    }
}
