package com.trabalho_lpoo.view;

import com.trabalho_lpoo.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {

    private String[] colunas = new String[]{"Nome", "sobrenome", "rg", "cpf", "endereço", "salário"};

    private List<Cliente> lista = new ArrayList();

    public ClienteTableModel(List<Cliente> lista) {
        this.lista = lista;
    }

    public ClienteTableModel() {
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        /*if(column==0)
            return true;
        return false;*/
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return customer.getNome();//if column 0 (nome)
            case 1:
                return customer.getSobreNome();//if column 1 (sobrenome)
            case 2:
                return customer.getRg();//if column 2 (rg)
            case 3:
                return customer.getCpf();//if column 3 (cpf)
            case 4:
                return customer.getEndereco();//if column 4 (endereço)
            case 5:
                return customer.getSalario();//if column 5 (salario)

            default:
                return null;
        }
    }

    public boolean removeCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void adicionaCliente(Cliente customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);//update JTable
    }

    public void setListaClientes(List<Cliente> Clientes) {
        this.lista = Clientes;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,Clientes.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Cliente getCliente(int linha) {
        return lista.get(linha);
    }

    void removeClientes(List<Cliente> listaParaExcluir) {
        listaParaExcluir.forEach((Cliente) -> {
            removeCliente(Cliente);
        });
    }

}
