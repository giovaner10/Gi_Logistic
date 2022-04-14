package br.com.gio.gi_logistic.service;

import br.com.gio.gi_logistic.exceptionhandler.NegocioException;
import br.com.gio.gi_logistic.model.Cliente;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.StatusEntrega;
import br.com.gio.gi_logistic.repository.ClienteRepository;
import br.com.gio.gi_logistic.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private EntregaRepository repository;
    private ClienteRepository clienteRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        boolean cliente = clienteRepository.existsById(entrega.getCliente().getId());
        if(!cliente)  throw new  NegocioException("Cliente nao encontrado") ;

        entrega.setCliente(entrega.getCliente());
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return repository.save(entrega);
    }

    public void excluir(Integer id){
        repository.deleteById(id);
    }

    public Optional<Entrega> findById(Integer id){
       return repository.findById(id);
    }

}
