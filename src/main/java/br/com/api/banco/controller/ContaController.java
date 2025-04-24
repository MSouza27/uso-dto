package br.com.api.banco.controller;

import br.com.api.banco.dto.ValidarTransacaoDTO;
import br.com.api.banco.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/saque")
    @Transactional
    public ResponseEntity<ValidarTransacaoDTO> validarSaque(@RequestBody @Valid ValidarTransacaoDTO validarTransacaoDTO){
        var dados = contaService.verificarSaldo(validarTransacaoDTO);
        return ResponseEntity.status(201).body(dados);
    }

    @PostMapping("/deposito")
    @Transactional
    public ResponseEntity<ValidarTransacaoDTO> validarDeposito(@RequestBody @Valid ValidarTransacaoDTO validarTransacaoDTO){
        var dados = contaService.depositoConta(validarTransacaoDTO);
        return ResponseEntity.status(201).body(dados);
    }
}
