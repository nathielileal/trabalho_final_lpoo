package com.trabalho_lpoo.view;

import com.trabalho_lpoo.controller.ClienteController;
import com.trabalho_lpoo.model.Cliente;
import java.util.List;
import javax.swing.JOptionPane;

public class JanelaClienteView extends javax.swing.JFrame {

    /**
     * Creates new form JanelaClienteView
     */
    public JanelaClienteView() {
        initComponents();
    }

    public void setController(ClienteController controller) {
        botoesClienteView.setController(controller);

    }

    public void initView() {
        /* Create and display the form */
        tabelaClienteView.setJanelaView(this);
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public Cliente getClienteFormulario() {
        return this.formularioClienteView.getClienteFormulario();
    }

    public void inserirClienteView(Cliente Cliente) {
        tabelaClienteView.inserirClienteTabela(Cliente);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarListaClientes(List<Cliente> lista) {
        tabelaClienteView.setListaClientesTabela(lista);
    }

    public List<Cliente> getClientesParaExcluir() {
        return this.tabelaClienteView.getClientesParaExcluirDaTabela();
    }

    public void excluirClientesView(List<Cliente> listaParaExcluir) {
        tabelaClienteView.excluirClientesDaTabela(listaParaExcluir);
    }

    public Cliente getClienteParaAtualizar() {
        return formularioClienteView.getClienteParaAtualizar();
    }

    public void atualizarCliente(Cliente Cliente) {
        tabelaClienteView.atualizarClienteNaTabela(Cliente);
    }

    public void limparClienteAtualizar() {
        formularioClienteView.limparClienteAtualizar();
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private BotoesClienteView getBotoesClienteView() {
        return botoesClienteView;
    }

    protected FormularioClienteView getFormularioClienteView() {
        return formularioClienteView;
    }

    private TabelaClienteView getTabelaClienteView() {
        return tabelaClienteView;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        botoesClienteView = new com.trabalho_lpoo.view.BotoesClienteView();
        tabelaClienteView = new com.trabalho_lpoo.view.TabelaClienteView();
        formularioClienteView = new com.trabalho_lpoo.view.FormularioClienteView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(formularioClienteView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tabelaClienteView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(botoesClienteView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(botoesClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(formularioClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private com.trabalho_lpoo.view.BotoesClienteView botoesClienteView;
    private com.trabalho_lpoo.view.FormularioClienteView formularioClienteView;
    private com.trabalho_lpoo.view.TabelaClienteView tabelaClienteView;
    // End of variables declaration       
}
