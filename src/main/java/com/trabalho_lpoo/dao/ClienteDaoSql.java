package com.trabalho_lpoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.trabalho_lpoo.model.Cliente;
import java.io.IOException;

public class ClienteDaoSql implements ClienteDao {

    private final String insert = "INSERT INTO Cliente (nome, sobre_nome, rg, cpf, endereco, salario) VALUES (?, ?, ?, ?, ?, ?)";
    private final String select = "SELECT * FROM Cliente";
    private final String update = "UPDATE Cliente SET nome=?, sobre_nome=?, rg=?, cpf=?, endereco=?, salario=? WHERE id=?";
    private final String delete = "DELETE FROM Cliente WHERE id=?";
    private final String selectByCpf = "select id, nome, sobre_nome, rg, cpf, endereco, salario, data_nascimento from cliente where cpf = ?";

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null) {
            return dao = new ClienteDaoSql();
        } else {
            return dao;
        }
    }

    public ClienteDaoSql() {
    }

    @Override
    public void add(Cliente cliente) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getSobreNome());
            stmtAdiciona.setString(3, cliente.getRg());
            stmtAdiciona.setString(4, cliente.getCpf());
            stmtAdiciona.setString(5, cliente.getEndereco());
            stmtAdiciona.setDouble(6, cliente.getSalario());

            stmtAdiciona.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(select); ResultSet rs = stmtLista.executeQuery()) {
            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String sobreNome = rs.getString("sobre_nome");
                String rg = rs.getString("rg");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                double salario = rs.getDouble("salario");

                Cliente cliente = new Cliente(id, nome, sobreNome, rg, cpf, endereco, salario);
                clientes.add(cliente);
            }

            return clientes;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = connection.prepareStatement(update)) {
            stmtAtualiza.setString(1, cliente.getNome());
            stmtAtualiza.setString(2, cliente.getSobreNome());
            stmtAtualiza.setString(3, cliente.getRg());
            stmtAtualiza.setString(4, cliente.getCpf());
            stmtAtualiza.setString(5, cliente.getEndereco());
            stmtAtualiza.setDouble(6, cliente.getSalario());
            stmtAtualiza.setLong(7, cliente.getId());

            stmtAtualiza.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void delete(Cliente cliente) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = connection.prepareStatement(delete)) {
            stmtExcluir.setLong(1, cliente.getId());

            stmtExcluir.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente getClienteByCpf(String cpf) throws Exception {

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtBuscar = connection.prepareStatement(selectByCpf)) {
            stmtBuscar.setString(1, cpf);

            try (ResultSet rs = stmtBuscar.executeQuery()) {
                if (rs.next()) {
                    long id = rs.getLong("id");
                    String nome = rs.getString("nome");
                    String sobreNome = rs.getString("sobre_nome");
                    String rg = rs.getString("rg");
                    String endereco = rs.getString("endereco");
                    double salario = rs.getDouble("salario");

                    Cliente cliente = new Cliente(id, nome, sobreNome, rg, cpf, endereco, salario);

                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(List<Cliente> clientes) throws Exception {
        System.out.println("[INFO] Iniciando método delete para múltiplos clientes.");
        for (Cliente cliente : clientes) {
            delete(cliente);
        }
    }

    @Override
    public Cliente getById(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
