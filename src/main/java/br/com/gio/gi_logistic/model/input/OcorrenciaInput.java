package br.com.gio.gi_logistic.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaInput {

    @NotBlank
    private String descricao;
}
