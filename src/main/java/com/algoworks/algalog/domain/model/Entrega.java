package com.algoworks.algalog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;

    @Valid
    @NotNull
    @ManyToOne
    @ConvertGroup(from = Default.class, to =ValidationGroups.ClienteId.class)

    private  Cliente cliente;
    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;
    @NotNull
    private BigDecimal taxa;
    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private  StatusEntrega status;
    @Transient
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

    public Ocorrencia adicionarOcorrencia(String descricao) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        this.getOcorrencias().add(ocorrencia);

        return ocorrencia;
    }
}


