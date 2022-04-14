package br.com.gio.gi_logistic.DTO;

import br.com.gio.gi_logistic.model.Destinatario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioModel {
    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    public DestinatarioModel(Destinatario destinatario) {
        this.nome = destinatario.getNome();
        this.bairro = destinatario.getBairro();
        this.numero = destinatario.getNumero();
        this.complemento = destinatario.getComplemento();
        this.logradouro = destinatario.getLogradouro();

    }

    public DestinatarioModel() {
    }
}
