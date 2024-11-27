package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import trabalho_final.Model.Cliente;

public class ClienteDaoSql implements ClienteDao {
    private ConnectionFactory connectionFactory;

    private final String insert = "INSERT INTO Cliente (nome, sobre_nome, rg, cpf, endereco, salario) VALUES (?, ?, ?, ?, ?, ?)";
    private final String select = "SELECT * FROM Cliente";
    private final String update = "UPDATE Cliente SET nome=?, sobre_nome=?, rg=?, cpf=?, endereco=?, salario=? WHERE id=?";
    private final String delete = "DELETE FROM Cliente WHERE id=?";

    private ClienteDaoSql() {}

    private static ClienteDaoSql dao;

    public static ClienteDaoSql getClienteDaoSql() {
        if (dao == null)
            return dao = new ClienteDaoSql();
        else
            return dao;
    }

    public ClienteDaoSql(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void add(Cliente cliente) throws Exception {
        System.out.println("[INFO] Iniciando método add para cliente: " + cliente);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + insert);

            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getSobreNome());
            stmtAdiciona.setString(3, cliente.getRg());
            stmtAdiciona.setString(4, cliente.getCpf());
            stmtAdiciona.setString(5, cliente.getEndereco());
            stmtAdiciona.setDouble(6, cliente.getSalario());

            System.out.println("[DEBUG] Executando instrução...");
            stmtAdiciona.execute();

            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            if (rs.next()) {
                long id = rs.getLong(1);
                cliente.setId(id);
                System.out.println("[INFO] Cliente adicionado com sucesso. ID gerado: " + id);
            } else {
                System.out.println("[WARN] Nenhum ID foi gerado para o cliente.");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao adicionar cliente: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public List<Cliente> getAll() throws Exception {
        System.out.println("[INFO] Iniciando método getAll.");
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtLista = connection.prepareStatement(select);
             ResultSet rs = stmtLista.executeQuery()) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Executando consulta: " + select);

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
                System.out.println("[INFO] ID" + id);
            }
            System.out.println("[INFO] Total de clientes recuperados: " + clientes.size());
            return clientes;
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao recuperar clientes: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void update(Cliente cliente) throws Exception {
        System.out.println("[INFO] Iniciando método update para cliente ID: " + cliente.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAtualiza = connection.prepareStatement(update)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + update);

            stmtAtualiza.setString(1, cliente.getNome());
            stmtAtualiza.setString(2, cliente.getSobreNome());
            stmtAtualiza.setString(3, cliente.getRg());
            stmtAtualiza.setString(4, cliente.getCpf());
            stmtAtualiza.setString(5, cliente.getEndereco());
            stmtAtualiza.setDouble(6, cliente.getSalario());
            stmtAtualiza.setLong(7, cliente.getId());

            System.out.println("[DEBUG] Executando instrução...");
            int rowsUpdated = stmtAtualiza.executeUpdate();
            System.out.println("[INFO] Total de linhas atualizadas: " + rowsUpdated);
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao atualizar cliente: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(Cliente cliente) throws Exception {
        System.out.println("[INFO] Iniciando método delete para cliente ID: " + cliente.getId());
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtExcluir = connection.prepareStatement(delete)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + delete);

            stmtExcluir.setLong(1, cliente.getId());

            System.out.println("[DEBUG] Executando instrução...");
            int rowsDeleted = stmtExcluir.executeUpdate();
            System.out.println("[INFO] Total de linhas excluídas: " + rowsDeleted);
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao excluir cliente: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

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
