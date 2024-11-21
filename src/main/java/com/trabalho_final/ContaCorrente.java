package com.trabalho_final;

public class ContaCorrente extends Conta {
    private final double limite;

    public ContaCorrente(Cliente dono, double depositoInicial, double limite) {
        super(dono);
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
}

