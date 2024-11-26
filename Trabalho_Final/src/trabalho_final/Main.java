/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho_final;

import DAO.ClienteDao;
import DAO.DaoFactory;
import DAO.DaoType;
import trabalho_final.Controller.ClienteController;
import trabalho_final.View.JanelaClienteView;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author rafae
 */
public class Main {
    public static void main(String[] args){
        JanelaClienteView view = new JanelaClienteView();
        ClienteDao modelDao = DaoFactory.getClienteDao(DaoType.SQL);
        ClienteController controller = new ClienteController(view,modelDao);
        
    }
    
}

