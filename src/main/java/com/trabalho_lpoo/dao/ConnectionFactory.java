package com.trabalho_lpoo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "@123Mudar";

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException, IOException {
        return DriverManager.getConnection(
                URL, USUARIO, SENHA);
    }

}
