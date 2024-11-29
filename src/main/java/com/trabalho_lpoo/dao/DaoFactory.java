package com.trabalho_lpoo.dao;

import static com.trabalho_lpoo.dao.DaoType.SQL;

public class DaoFactory {

    private DaoFactory() {}

    public static ClienteDao getClienteDao(DaoType type) {
        switch (type) {
            case SQL:
                return ClienteDaoSql.getClienteDaoSql();
            default:
                throw new RuntimeException("Tipo não existe:" + type);
        }
    }
    
    public static ContaDao getContaDao(DaoType type) {
        switch (type) {
            case SQL:
                return ContaDaoSql.getContaDaoSql();
            default:
                throw new RuntimeException("Tipo não existe:" + type);
        }
    }

}
