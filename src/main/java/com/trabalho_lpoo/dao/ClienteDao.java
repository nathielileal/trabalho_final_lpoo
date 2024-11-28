package com.trabalho_lpoo.dao;

import java.util.List;
import com.trabalho_lpoo.model.Cliente;

public interface ClienteDao extends Dao<Cliente>{
    public void delete(List<Cliente> lista) throws Exception;    
}
