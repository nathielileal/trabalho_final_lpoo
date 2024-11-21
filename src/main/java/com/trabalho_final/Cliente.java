package com.trabalho_final;

public class Cliente implements Comparable<Cliente> {
    private String nome;
    private String sobreNome;
    private String rg;
    private String cpf;
    private String endereco;
    private Conta conta;
    private Double salario;

    public Cliente(String nome, String sobreNome, String rg, String cpf, String endereco, Double salario) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    @Override
    public int compareTo(Cliente outroCliente) {
        int comparacaoNome = this.nome.compareTo(outroCliente.nome);
        if (comparacaoNome != 0) {
            return comparacaoNome;
        } else {
            return this.sobreNome.compareTo(outroCliente.sobreNome);
        }
    }
   
}

