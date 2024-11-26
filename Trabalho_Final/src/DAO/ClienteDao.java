/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import java.util.List;
import trabalho_final.Model.Cliente;



/**
 *
 * @author guilhe
 */
public interface ClienteDao extends Dao<Cliente>{
    public void delete(List<Cliente> lista) throws Exception;    
}
