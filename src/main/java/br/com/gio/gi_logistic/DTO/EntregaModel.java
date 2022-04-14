package br.com.gio.gi_logistic.DTO;

import br.com.gio.gi_logistic.model.Destinatario;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.StatusEntrega;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Setter
@Getter
public class EntregaModel {

    private Integer id;
    private String nomeCliente;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega statusEntrega;
    private OffsetDateTime dataPedido;
    private  OffsetDateTime dataFinalizacao;

    public EntregaModel(Entrega entrega) {

        this.id = entrega.getId();
        this.taxa = entrega.getTaxa();
        this.statusEntrega = entrega.getStatus();
        this.dataPedido = entrega.getDataPedido();
        this.dataFinalizacao = entrega.getDataFinalizacao();

        this.nomeCliente = entrega.getDestinatario().getNome();

        destinatario = new DestinatarioModel(entrega.getDestinatario());


    }

    public EntregaModel( ) {
    }
}
