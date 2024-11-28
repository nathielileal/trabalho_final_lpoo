package com.trabalho_lpoo.dao;

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

}
