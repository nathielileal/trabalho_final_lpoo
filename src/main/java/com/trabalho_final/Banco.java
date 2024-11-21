package com.trabalho_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Banco extends JFrame {

    public Banco() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Menu menuPanel = new Menu();
        CadastrarCliente cadastrarClientePanel = new CadastrarCliente();
        VinculaClienteConta vinculaClienteContaPanel = new VinculaClienteConta();
        ManipulaContaCliente manipulaContaClientePanel = new ManipulaContaCliente();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("Menu", menuPanel);
        jTabbedPane1.addTab("Cadastrar cliente", cadastrarClientePanel);
        jTabbedPane1.addTab("Vincula conta", vinculaClienteContaPanel);
        jTabbedPane1.addTab("Operações", manipulaContaClientePanel);
        
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setEnabledAt(i, false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        
        menuPanel.getBtnAcessar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
                    jTabbedPane1.setEnabledAt(i, true);
                    jTabbedPane1.setEnabledAt(0, false);
                }
                jTabbedPane1.setSelectedIndex(1);
            }
        });
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Banco().setVisible(true);
            }
        });
    }

    private javax.swing.JTabbedPane jTabbedPane1;
}
