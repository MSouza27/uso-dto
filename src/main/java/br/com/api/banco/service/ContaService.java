package br.com.api.banco.service;

import br.com.api.banco.dto.ValidarTransacaoDTO;
import br.com.api.banco.enums.TipoTransacao;
import br.com.api.banco.model.Conta;
import br.com.api.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public ValidarTransacaoDTO verificarSaldo(ValidarTransacaoDTO validarTransacaoDTO) {

        if (TipoTransacao.valueOf(validarTransacaoDTO.tipoTransacao()) == TipoTransacao.SAQUE
                && validarTransacaoDTO.saldoConta().compareTo(validarTransacaoDTO.valor()) > 0) {

            Conta retirada = new Conta();
            retirada.setNome(validarTransacaoDTO.nome());
            retirada.setSaldoConta(validarTransacaoDTO.saldoConta().subtract(validarTransacaoDTO.valor()));
            retirada.setTipoTransacao(validarTransacaoDTO.tipoTransacao());
            retirada.setValor(validarTransacaoDTO.valor());
            retirada.setHoraTransacao(LocalDateTime.now());

            Conta validar = contaRepository.save(retirada);

            return new ValidarTransacaoDTO(
                    validar.getNome(),
                    validar.getSaldoConta(),
                    validar.getTipoTransacao(),
                    validar.getValor(),
                    validar.getHoraTransacao()
            );

        }

        throw new IllegalArgumentException("Saldo Insuficiente para realizar a operação");
    }


    public ValidarTransacaoDTO depositoConta(ValidarTransacaoDTO validarTransacaoDTO){
           if (TipoTransacao.valueOf(validarTransacaoDTO.tipoTransacao()) == TipoTransacao.DEPOSITO){
               Conta deposito = new Conta();
               deposito.setNome(validarTransacaoDTO.nome());
               deposito.setSaldoConta(validarTransacaoDTO.saldoConta().add(validarTransacaoDTO.valor()));
               deposito.setTipoTransacao(validarTransacaoDTO.tipoTransacao());
               deposito.setValor(validarTransacaoDTO.valor());
               deposito.setHoraTransacao(LocalDateTime.now());

               Conta validar = contaRepository.save(deposito);

               return new ValidarTransacaoDTO(
                       validar.getNome(),
                       validar.getSaldoConta(),
                       validar.getTipoTransacao(),
                       validar.getValor(),
                       validar.getHoraTransacao()
               );
           }

           throw new IllegalArgumentException("Erro na validação do deposito");
    }

}


