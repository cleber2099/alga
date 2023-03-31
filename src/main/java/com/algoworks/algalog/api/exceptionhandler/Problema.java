package com.algoworks.algalog.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude
@Getter
@Setter
public class Problema {
    private Integer status;
    private OffsetDateTime datahora;
    private String titulo;
    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public  static class Campo{
        private String nome;
        private String mensagem;

    }

}
