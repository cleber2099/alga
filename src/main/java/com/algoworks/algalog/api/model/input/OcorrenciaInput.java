package com.algoworks.algalog.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OcorrenciaInput {
    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }
}
