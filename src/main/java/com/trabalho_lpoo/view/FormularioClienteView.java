package com.trabalho_lpoo.view;

import com.trabalho_lpoo.model.Cliente;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class FormularioClienteView extends javax.swing.JPanel {

    private Cliente ClienteSelecionadoParaAtualizacao;

    public FormularioClienteView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        campoEndereco = new javax.swing.JTextField();
        labelEndereco = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelSobrenome = new javax.swing.JLabel();
        campoSobrenome = new javax.swing.JTextField();
        campoRG = new javax.swing.JTextField();
        labelRG = new javax.swing.JLabel();
        campoCPF = new javax.swing.JFormattedTextField();
        labelCPF = new javax.swing.JLabel();
        labelSalario = new javax.swing.JLabel();
        campoSalario = new javax.swing.JFormattedTextField();

        labelEndereco.setText("Endereço");
        labelNome.setText("Nome");
        labelSobrenome.setText("Sobrenome");
        labelRG.setText("RG");
        labelCPF.setText("CPF");
        labelSalario.setText("Salário");

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            // Ajuste para aceitar números sem formato de moeda
            campoSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new NumberFormatter(NumberFormat.getNumberInstance())));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelNome)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(campoNome))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelSobrenome)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSobrenome))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelRG)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoRG))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelCPF)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoCPF))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelEndereco)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoEndereco))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelSalario)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSalario)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelNome)
                                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSobrenome)
                                        .addComponent(campoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelRG)
                                        .addComponent(campoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCPF)
                                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelEndereco)
                                        .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSalario)
                                        .addComponent(campoSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoSobrenome;
    private javax.swing.JTextField campoRG;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JFormattedTextField campoSalario;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSobrenome;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelSalario;

    public void setCliente(Cliente Cliente) {
        this.ClienteSelecionadoParaAtualizacao = Cliente;
        campoNome.setText(Cliente.getNome());
        campoSobrenome.setText(Cliente.getSobreNome());
        campoRG.setText(Cliente.getRg());
        campoCPF.setText(Cliente.getCpf());
        campoEndereco.setText(Cliente.getEndereco());
        campoSalario.setValue(Cliente.getSalario());
    }

    public void limparClienteAtualizar() {
        ClienteSelecionadoParaAtualizacao = null;
    }

    public Cliente getClienteParaAtualizar() {
        if (ClienteSelecionadoParaAtualizacao == null) {
            return null;
        }
        ClienteSelecionadoParaAtualizacao.setNome(campoNome.getText());
        ClienteSelecionadoParaAtualizacao.setSobreNome(campoSobrenome.getText());
        ClienteSelecionadoParaAtualizacao.setRg(campoRG.getText());
        ClienteSelecionadoParaAtualizacao.setCpf(campoCPF.getText());
        ClienteSelecionadoParaAtualizacao.setEndereco(campoEndereco.getText());
        ClienteSelecionadoParaAtualizacao.setSalario(((Number) campoSalario.getValue()).doubleValue());
        return ClienteSelecionadoParaAtualizacao;
    }

    public Cliente getClienteFormulario() {
        String nome = campoNome.getText();
        String sobrenome = campoSobrenome.getText();
        String rg = campoRG.getText();
        String cpf = campoCPF.getText();
        String endereco = campoEndereco.getText();
        double salario = ((Number) campoSalario.getValue()).doubleValue();
        return new Cliente(-1, nome, sobrenome, rg, cpf, endereco, salario);
    }
}
