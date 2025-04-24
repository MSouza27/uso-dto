package br.com.api.banco.enums;

public enum TipoTransacao {
    SAQUE("Saque"),
    DEPOSITO("deposito"),
    PAGAMENTO("Pagamento"),
    TRANSFERENCIA("Transferencia");

    TipoTransacao(String descricao) {

    }

}
