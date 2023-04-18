package com.algoworks.algalog.domain.exception;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



public class EntidadeNaoEncontradaException  extends  NegocioException{
     public  EntidadeNaoEncontradaException (String message){
         super(message);
     }

    private static final long serialVersionUID = 1L;
}
