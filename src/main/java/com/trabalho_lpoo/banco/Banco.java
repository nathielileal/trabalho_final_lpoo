package com.trabalho_lpoo.banco;

import com.trabalho_lpoo.controller.ClienteController;
import com.trabalho_lpoo.dao.ClienteDao;
import com.trabalho_lpoo.dao.DaoFactory;
import com.trabalho_lpoo.dao.DaoType;
import com.trabalho_lpoo.view.JanelaClienteView;

public class Banco {

    public static void main(String[] args) {
        JanelaClienteView view = new JanelaClienteView();
        ClienteDao modelDao = DaoFactory.getClienteDao(DaoType.SQL);
        ClienteController controller = new ClienteController(view,modelDao);
    }
}
