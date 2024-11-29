package com.trabalho_lpoo.model;

public abstract class Conta implements ContaI {
    private static int numeroSequencial = 1;
    protected long numero;
    protected double saldo;
    protected long idCliente;
    protected String tipo;

    public Conta(long idCliente) {
        this.numero = numeroSequencial++;
        this.idCliente = idCliente;
        this.saldo = 0;
        this.tipo = "";
    }

    @Override
    public boolean deposita(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean saca(double valor) {
        if (valor > 0) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public long getCliente() {
        return idCliente;
    }

    @Override
    public long getNumero() {
        return numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
}
