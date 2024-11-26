/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class DaoFactory {
    private DaoFactory(){
    }
    
    public static ClienteDao getClienteDao(DaoType type){
        switch(type){
            case SQL: 
                return ClienteDaoSql.getClienteDaoSql();
            default:
                throw new RuntimeException("Tipo não existe:"+type);
        }
    }
    
    
}

