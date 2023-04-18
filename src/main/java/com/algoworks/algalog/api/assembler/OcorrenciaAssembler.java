package com.algoworks.algalog.api.assembler;

import com.algoworks.algalog.api.model.OcorrenciaModel;
import com.algoworks.algalog.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaModel toModel(Ocorrencia ocorrencia){
        return  modelMapper.map(ocorrencia, OcorrenciaModel.class);
    }
    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia>ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());

    }

}
