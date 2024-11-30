package com.trabalho_lpoo.banco;

import com.trabalho_lpoo.controller.ClienteController;
import com.trabalho_lpoo.controller.ManipulaContaController;
import com.trabalho_lpoo.controller.VincularContaController;
import com.trabalho_lpoo.dao.ClienteDao;
import com.trabalho_lpoo.dao.ContaDao;
import com.trabalho_lpoo.dao.DaoFactory;
import com.trabalho_lpoo.dao.DaoType;
import com.trabalho_lpoo.view.JanelaClienteView;
import com.trabalho_lpoo.view.ManipulaContaView;
import com.trabalho_lpoo.view.VincularContaView;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Banco {

    public static void main(String[] args) {
        JTabbedPane tabbedPane = new JTabbedPane();

        JanelaClienteView janelaClienteView = new JanelaClienteView();
        VincularContaView vincularContaView = new VincularContaView();
        ManipulaContaView manipulaContaView = new ManipulaContaView();

        ClienteDao modelDao = DaoFactory.getClienteDao(DaoType.SQL);
        ClienteController controller = new ClienteController(janelaClienteView, modelDao);

        tabbedPane.addTab("Cadastrar cliente", janelaClienteView.getContentPane());
        tabbedPane.addTab("Vincula conta", vincularContaView);
        tabbedPane.addTab("Operações", manipulaContaView.getContentPane());

        JFrame mainFrame = new JFrame("Banco");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(tabbedPane); 
        mainFrame.setSize(800, 600); 
        mainFrame.setVisible(true);
    }
}
