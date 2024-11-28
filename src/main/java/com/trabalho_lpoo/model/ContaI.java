package com.trabalho_lpoo.model;

public interface ContaI {

    boolean deposita(double valor);

    boolean saca(double valor);

    Cliente getDono();

    int getNumero();

    double getSaldo();

    void remunera();

}
