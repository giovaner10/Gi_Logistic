package br.com.gio.gi_logistic.service;

import br.com.gio.gi_logistic.DTO.DestinatarioModel;
import br.com.gio.gi_logistic.DTO.EntregaModel;
import br.com.gio.gi_logistic.assembler.EntregaAssembler;
import br.com.gio.gi_logistic.exceptionhandler.NegocioException;
import br.com.gio.gi_logistic.model.Destinatario;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.StatusEntrega;
import br.com.gio.gi_logistic.repository.ClienteRepository;
import br.com.gio.gi_logistic.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private EntregaRepository repository;
    private ClienteRepository clienteRepository;
    private EntregaAssembler entregaAssembler;

    @Transactional
    public EntregaModel solicitar(Entrega entrega) {

        boolean cliente = clienteRepository.existsById(entrega.getCliente().getId());
        if (!cliente) throw new NegocioException("Cliente nao encontrado");

        entrega.setCliente(entrega.getCliente());
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

         repository.save(entrega);
        EntregaModel entregaModel1 = new EntregaModel(entrega);

        return entregaModel1;
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public ResponseEntity<EntregaModel> findById(Integer id) {
        return repository.findById(id)

                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());

                    /*return repository.findById(id)
                            .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                            .orElse(ResponseEntity.notFound().build());*/

    }

}
