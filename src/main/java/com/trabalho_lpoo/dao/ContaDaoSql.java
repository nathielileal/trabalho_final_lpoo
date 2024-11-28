package com.trabalho_lpoo.dao;

import com.trabalho_lpoo.model.Conta;
import com.trabalho_lpoo.model.ContaCorrente;
import com.trabalho_lpoo.model.ContaInvestimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContaDaoSql implements ContaDao {

    private ConnectionFactory connectionFactory;

    private final String insert = "insert into conta (saldo, cliente_id, tipo_conta) values (?, ?, ?)";
    private final String insertCorrente = "insert into contacorrente (numero, limite) values (?, ?)";
    private final String insertInventimento = "insert into containvestimento (numero, montante_minimo, deposito_minimo) values (?, ?, ?)";

    private ContaDaoSql() {
    }

    private static ContaDaoSql dao;

    public static ContaDaoSql getContaDaoSql() {
        if (dao == null) {
            return dao = new ContaDaoSql();
        } else {
            return dao;
        }
    }

    public ContaDaoSql(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public long criarConta(Conta conta) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

            stmtAdiciona.setDouble(1, conta.getSaldo());
            stmtAdiciona.setLong(2, conta.getCliente());
            stmtAdiciona.setString(3, conta.getTipo());

            stmtAdiciona.execute();

            ResultSet rs = stmtAdiciona.getGeneratedKeys();

            if (rs.next()) {
                return rs.getLong("numero");
            }
        } catch (SQLException e) {
            throw e;
        }

        return 0;
    }

    public void criarContaCorrente(ContaCorrente cc) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insertCorrente, Statement.RETURN_GENERATED_KEYS)) {

            stmtAdiciona.setLong(1, cc.getNumero());
            stmtAdiciona.setDouble(2, cc.getLimite());

            stmtAdiciona.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void criarContaInvestimento(ContaInvestimento ci) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insertInventimento, Statement.RETURN_GENERATED_KEYS)) {

            stmtAdiciona.setLong(1, ci.getNumero());
            stmtAdiciona.setDouble(2, ci.getMontante());
            stmtAdiciona.setDouble(3, ci.getDeposito());

            stmtAdiciona.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void add(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Conta> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Conta conta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Conta getById(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
