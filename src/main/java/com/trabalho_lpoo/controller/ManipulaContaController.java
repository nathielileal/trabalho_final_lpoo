package com.trabalho_lpoo.controller;

import com.trabalho_lpoo.dao.ContaDao;
import com.trabalho_lpoo.view.ManipulaContaView;

public class ManipulaContaController {
    
    private ManipulaContaView view;
    private ContaDao modelDao;

    public ManipulaContaController(ManipulaContaView view, ContaDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }
}
