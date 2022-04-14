package br.com.gio.gi_logistic.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdInput {

    @NotNull
    private Integer id;
}
