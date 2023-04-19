package com.algoworks.algalog.api.controller;
import com.algoworks.algalog.api.assembler.OcorrenciaAssembler;
import com.algoworks.algalog.api.model.OcorrenciaModel;
import com.algoworks.algalog.api.model.input.OcorrenciaInput;
import com.algoworks.algalog.domain.model.Entrega;
import com.algoworks.algalog.domain.model.Ocorrencia;
import com.algoworks.algalog.domain.service.BuscaEntregaService;
import com.algoworks.algalog.domain.service.RegistroOcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {
    @Autowired
    private BuscaEntregaService buscaEntregaService;
    @Autowired
    private RegistroOcorrenciaService registroOcorrenciaService;
    @Autowired
    private OcorrenciaAssembler ocorrenciaAssembler;
    @PostMapping("/entrega/{entregaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());
        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }
    @GetMapping("/entrega/{entregaid}")
    public List<OcorrenciaModel> listar(@PathVariable(name = "entregaid") Long entregaId){
        Entrega entrega =  buscaEntregaService.buscar(entregaId);
        return  ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
