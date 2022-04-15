package br.com.gio.gi_logistic.assembler;

import br.com.gio.gi_logistic.model.Ocorrencia;
import br.com.gio.gi_logistic.model.input.OcorrenciaModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModel toEntity(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }

    public List<OcorrenciaModel> toList(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
