package com.trabalho_lpoo.dao;

import com.trabalho_lpoo.model.Conta;
import com.trabalho_lpoo.model.ContaCorrente;
import com.trabalho_lpoo.model.ContaInvestimento;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContaDaoSql implements ContaDao {

    private final String insert = "insert into conta (saldo, cliente_id, tipo_conta) values (?, ?, ?)";
    private final String insertCorrente = "insert into contacorrente (numero, limite) values (?, ?)";
    private final String insertInventimento = "insert into containvestimento (numero, montante_minimo, deposito_minimo) values (?, ?, ?)";
    private final String select = "select cliente.cpf, conta.numero from conta left join cliente on cliente.id = conta.cliente_id";
    private final String selectCliente = "select numero, nome, sobre_nome, tipo_conta from conta join cliente on conta.cliente_id = cliente.id WHERE cpf = ?";
    private final String selectSaldo = "select saldo from conta where numero = ?";
    private final String selectIdSaldo = "SELECT numero, saldo FROM conta JOIN cliente ON conta.cliente_id = cliente.id WHERE cpf = ?";
    private final String updateSaldo = "UPDATE conta SET saldo = ? WHERE numero = ?";

    private static ContaDaoSql dao;

    public static ContaDaoSql getContaDaoSql() {
        if (dao == null) {
            return dao = new ContaDaoSql();
        } else {
            return dao;
        }
    }

    public ContaDaoSql() {
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

   public List<String> getCpf() throws SQLException, IOException {
        final List<String> cpf = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBuscar = connection.prepareStatement(select)) {

            try (ResultSet rs = stmtBuscar.executeQuery()) {
                while (rs.next()) {
                    cpf.add(rs.getString("cpf"));
                }
            }
        }

        return cpf;
    }
   
    public String[] getClienteByCpf(String cpf) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBuscar = connection.prepareStatement(selectCliente)) {
            stmtBuscar.setString(1, cpf);

            try (ResultSet rs = stmtBuscar.executeQuery()) {
                if (rs.next()) {
                    long numero = rs.getLong("numero");
                    String nome = rs.getString("nome");
                    String sobrenome = rs.getString("sobre_nome");
                    String tipo = rs.getString("tipo_conta");

                    return new String[]{String.valueOf(numero), nome, sobrenome, tipo};
                }
            }
        }

        return null;
    }

    public double getSaldo(long numero) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBuscar = connection.prepareStatement(selectSaldo)) {
            stmtBuscar.setLong(1, numero);
            
            try (ResultSet rs = stmtBuscar.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo");
                }
            }
        }

        return 0;
    }

    public double remunerar(String cpf) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBusca = connection.prepareStatement(selectIdSaldo); PreparedStatement stmtAtualiza = connection.prepareStatement(updateSaldo)) {
            stmtBusca.setString(1, cpf);

            ResultSet rs = stmtBusca.executeQuery();

            if (rs.next()) {
                int contaId = rs.getInt("numero");
                double saldoAtual = rs.getDouble("saldo");
                double saldoAtualizado = saldoAtual * 1.01; // 1% de remuneração

                stmtAtualiza.setDouble(1, saldoAtualizado);
                stmtAtualiza.setInt(2, contaId);
                stmtAtualiza.executeUpdate();

                return saldoAtualizado;
            }
        }

        return -1;
    }

    public double depositar(String cpf, double valorDeposito) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBusca = connection.prepareStatement(selectIdSaldo); PreparedStatement stmtAtualiza = connection.prepareStatement(updateSaldo)) {
            stmtBusca.setString(1, cpf);
            ResultSet rs = stmtBusca.executeQuery();

            if (rs.next()) {
                int contaId = rs.getInt("numero");
                double saldoAtual = rs.getDouble("saldo");
                double saldoAtualizado = saldoAtual + valorDeposito;

                stmtAtualiza.setDouble(1, saldoAtualizado);
                stmtAtualiza.setInt(2, contaId);
                stmtAtualiza.executeUpdate();

                return saldoAtualizado;
            }
        }

        return -1;
    }

    public double sacarValor(String cpf, double valorSaque) throws SQLException, IOException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBusca = connection.prepareStatement(selectIdSaldo); PreparedStatement stmtAtualiza = connection.prepareStatement(updateSaldo)) {
            stmtBusca.setString(1, cpf);
            ResultSet rs = stmtBusca.executeQuery();

            if (rs.next()) {
                int contaId = rs.getInt("numero");
                double saldoAtual = rs.getDouble("saldo");

                if (saldoAtual >= valorSaque) {
                    double saldoAtualizado = saldoAtual - valorSaque;

                    stmtAtualiza.setDouble(1, saldoAtualizado);
                    stmtAtualiza.setInt(2, contaId);
                    stmtAtualiza.executeUpdate();

                    return saldoAtualizado;
                }
            }
        }

        return -1;
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
