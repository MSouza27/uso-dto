package br.com.api.banco.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ValidarTransacaoDTO(
        String nome,
        BigDecimal saldoConta,
        String tipoTransacao,
        BigDecimal valor,
        LocalDateTime horaTransacao
) {
}
