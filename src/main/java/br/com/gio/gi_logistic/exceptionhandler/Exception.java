package br.com.gio.gi_logistic.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exception {
    private Integer status;
    private LocalDateTime dataHora;
    private  String titulo;
    private List<Campo> campos;


    @Data
    @AllArgsConstructor
    public static class Campo{
        private String nome;
        private String mensagem;


    }
}
