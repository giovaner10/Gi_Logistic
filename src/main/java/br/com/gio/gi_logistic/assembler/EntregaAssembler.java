package br.com.gio.gi_logistic.assembler;

import br.com.gio.gi_logistic.DTO.EntregaModel;
import br.com.gio.gi_logistic.model.Entrega;
import br.com.gio.gi_logistic.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
