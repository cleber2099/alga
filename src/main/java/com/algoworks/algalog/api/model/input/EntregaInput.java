package com.algoworks.algalog.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaInput {
    @Valid
    @NotNull
    private ClienteIdInput cliente;
    @Valid
    @NotNull
    private DestinatarioInput destinatario;
    @Valid
    @NotNull
    private BigDecimal taxa;
}
