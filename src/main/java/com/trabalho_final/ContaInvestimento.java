package com.trabalho_final;

public class ContaInvestimento extends Conta {
    private final double montanteMinimo;
    private final double depositoMinimo;

    public ContaInvestimento(Cliente dono, double depositoInicial, double montanteMinimo, double depositoMinimo) {
        super(dono);
        this.montanteMinimo = montanteMinimo;
        this.depositoMinimo = depositoMinimo;
        deposita(depositoInicial);
    }


    @Override
    public boolean deposita(double valor) {
        if (valor >= depositoMinimo) {
            return super.deposita(valor);
        }
        return false;
    }

    @Override
    public boolean saca(double valor) {
        if (valor > 0 && (saldo - valor) >= montanteMinimo) {
            return super.saca(valor);
        }
        return false;
    }

    @Override
    public void remunera() {
        saldo += saldo * 0.02; 
    }
}
