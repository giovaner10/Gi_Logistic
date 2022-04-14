package br.com.gio.gi_logistic.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModel {

    private Integer id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
