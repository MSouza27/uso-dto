package br.com.api.banco.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "conta")
@Setter
@Getter
public class Conta {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private BigDecimal saldoConta;
    private String tipoTransacao;
    private BigDecimal valor;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(nullable = false, updatable = false)
    private LocalDateTime horaTransacao;
}
