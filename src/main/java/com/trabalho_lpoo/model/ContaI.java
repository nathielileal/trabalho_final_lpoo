package com.trabalho_lpoo.model;

public interface ContaI {

    boolean deposita(double valor);

    boolean saca(double valor);

    long getCliente();

    long getNumero();

    double getSaldo();
    
    String getTipo();

    void remunera();

}
