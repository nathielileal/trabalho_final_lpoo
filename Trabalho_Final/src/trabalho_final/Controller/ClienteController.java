/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_final.Controller;

import DAO.ClienteDao;
import java.util.List;
import trabalho_final.Model.Cliente;
import trabalho_final.View.JanelaClienteView;

/**
 *
 * @author rafae
 */
public class ClienteController {
    private JanelaClienteView view;
    private ClienteDao modelDao;

    public ClienteController(JanelaClienteView view, ClienteDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }
    
    private void initController(){
        this.view.setController(this);
        this.view.initView();
    }

    public void cadastrarCliente() {
        try{
            Cliente cliente = view.getClienteFormulario();
            modelDao.add(cliente);
            view.inserirClienteView(cliente);
            view.apresentaInfo("Adicionado com sucesso!!!");
            
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao criar cliente.");
        }
    }

    public void alterarCliente() {
        try{
            
            Cliente cliente = (Cliente) view.getClienteParaAtualizar();
            if(cliente==null){
                view.apresentaInfo("Selecione um contato na tabela para atualizar.");
                return;
            }
            modelDao.update(cliente);
            view.atualizarCliente(cliente);
            
        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar contato.");
        }
    }

    public void excluirCliente() {
        try{
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            modelDao.delete(listaParaExcluir);
            view.excluirClientesView(listaParaExcluir);
        }catch(Exception ex){
            view.apresentaErro("Erro ao excluir contatos.");
        }
    }

    public void listarCliente() {
        try{
            view.limparClienteAtualizar();
            List<Cliente> lista = this.modelDao.getAll();
            view.mostrarListaClientes(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao listar contatos.");
        }
    }

    
    
}