package com.trabalho_lpoo.model;

public class ContaCorrente extends Conta {

    private final double limite;

    public ContaCorrente(long cliente, double depositoInicial, double limite) {
        super(cliente);
        this.limite = limite;
        deposita(depositoInicial);
    }

    @Override
    public boolean saca(double valor) {
        if (valor > 0 && (saldo + limite) >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void remunera() {
        saldo += saldo * 0.01;
    }

    public double getLimite() {
        return limite;
    }
    
}
