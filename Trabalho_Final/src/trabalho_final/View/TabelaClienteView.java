/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_final.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import trabalho_final.Model.Cliente;


/**
 *
 * @author rafae
 */
public class TabelaClienteView extends javax.swing.JPanel {
    private ClienteTableModel modeloTabelaCliente = new ClienteTableModel();
    private JanelaClienteView janela;
    private int linhaClicadaParaAtualizacao = -1;
    /**
     * Creates new form TabelaClienteView
     */
    public TabelaClienteView() {
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

        scrollPane = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        tabelaCliente.setModel(modeloTabelaCliente);
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tabelaCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {                                           
        //Pega a linha clicada
        linhaClicadaParaAtualizacao = this.tabelaCliente.rowAtPoint(evt.getPoint());
        //Pega o Cliente da linha clicada
        Cliente Cliente = modeloTabelaCliente.getCliente(linhaClicadaParaAtualizacao);
        //Seta os dados no formulário
        janela.getFormularioClienteView().setCliente(Cliente);
    }                                          

    public JTable getTabelaCliente() {
        return tabelaCliente;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration                   

    public void setJanelaView(JanelaClienteView janela) {
        this.janela = janela;
    }
    
    public void inserirClienteTabela(Cliente Cliente) {
        modeloTabelaCliente.adicionaCliente(Cliente);
    }

    public void setListaClientesTabela(List<Cliente> lista) {
        modeloTabelaCliente.setListaClientes(lista);
    }
    
    public List<Cliente> getClientesParaExcluirDaTabela() {
        int[] linhasSelecionadas = this.getTabelaCliente().getSelectedRows();
        List<Cliente> listaExcluir = new ArrayList();
        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Cliente Cliente = modeloTabelaCliente.getCliente(linhasSelecionadas[i]);
            listaExcluir.add(Cliente);
        }
        return listaExcluir;
    }
    
    public void excluirClientesDaTabela(List<Cliente> listaParaExcluir) {
        modeloTabelaCliente.removeClientes(listaParaExcluir);
    }

    public void atualizarClienteNaTabela(Cliente Cliente) {
        
        modeloTabelaCliente.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao);
        
    }

}


