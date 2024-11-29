package com.trabalho_lpoo.controller;

import com.trabalho_lpoo.dao.ContaDao;
import com.trabalho_lpoo.view.VincularContaView;

public class VincularContaController {
    
    private VincularContaView view;
    private ContaDao modelDao;

    public VincularContaController(VincularContaView view, ContaDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }
    
}
