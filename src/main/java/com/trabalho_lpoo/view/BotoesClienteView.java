/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trabalho_lpoo.view;

import com.trabalho_lpoo.controller.ClienteController;

/**
 *
 * @author nathieli
 */
public class BotoesClienteView extends javax.swing.JPanel {
    
    /**
     * Creates new form BotoesClienteView
     */
    public BotoesClienteView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botaoCriar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoListar = new javax.swing.JButton();

        botaoCriar.setText("Criar");

        botaoAtualizar.setText("Atualizar");

        botaoExcluir.setText("Excluir");

        botaoListar.setText("Listar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoListar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCriar)
                    .addComponent(botaoAtualizar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoListar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoCriar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoListar;
    // End of variables declaration                   

    public void setController(ClienteController controller) {
      
        this.botaoCriar.addActionListener(e -> controller.cadastrarCliente());
        this.botaoAtualizar.addActionListener(e -> controller.alterarCliente());
        this.botaoExcluir.addActionListener(e -> controller.excluirCliente());
        this.botaoListar.addActionListener(e -> controller.listarCliente());

    }
    
}
