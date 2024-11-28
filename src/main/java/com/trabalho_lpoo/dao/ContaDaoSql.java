package com.trabalho_lpoo.dao;

import com.trabalho_lpoo.model.Conta;
import com.trabalho_lpoo.model.ContaCorrente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContaDaoSql implements ContaDao {

    private ConnectionFactory connectionFactory;

    private final String insert = "insert into conta (saldo, cliente_id, tipo_conta) values (?, ?, ?)";
    private final String select = "select * from conta";
    private final String update = "update conta set saldo = ?, cliente_id = ?, tipo_conta = ? where numero = ?";
    private final String delete = "delete from conta where numero = ?";

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

    @Override
    public void add(Conta conta) throws Exception {
        System.out.println("[INFO] Iniciando método add para conta: " + conta);
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + insert);

            stmtAdiciona.setDouble(1, conta.getSaldo());
            stmtAdiciona.setLong(2, conta.getCliente());
            stmtAdiciona.setString(3, conta.getTipo());

            System.out.println("[DEBUG] Executando instrução...");
            stmtAdiciona.execute();

            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            if (rs.next()) {
                long id = conta.getNumero();
                System.out.println("[INFO] Conta adicionado com sucesso. ID gerado: " + id);
            } else {
                System.out.println("[WARN] Nenhum ID foi gerado para o conta.");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao adicionar conta: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Conta> getAll() throws Exception {
        System.out.println("[INFO] Iniciando método getAll.");
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtLista = connection.prepareStatement(select); ResultSet rs = stmtLista.executeQuery()) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Executando consulta: " + select);

            List<Conta> contas = new ArrayList<>();
            while (rs.next()) {
                long numero = rs.getLong("numero");
                double saldo = rs.getDouble("saldo");
                long idCliente = rs.getLong("cliente_id");
                String tipo = rs.getString("tipo");

//                Conta conta = new Conta();
//                contas.add(conta);
                System.out.println("[INFO] ID" + numero);
            }
            System.out.println("[INFO] Total de contas recuperados: " + contas.size());
            return contas;
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao recuperar contas: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Conta conta) throws Exception {
        System.out.println("[INFO] Iniciando método update para conta ID: " + conta.getNumero());
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtAtualiza = connection.prepareStatement(update)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + update);

            stmtAtualiza.setDouble(1, conta.getSaldo());
            stmtAtualiza.setLong(2, conta.getCliente());
            stmtAtualiza.setString(3, conta.getTipo());
            stmtAtualiza.setDouble(4, conta.getNumero());

            System.out.println("[DEBUG] Executando instrução...");

            int rowsUpdated = stmtAtualiza.executeUpdate();

            System.out.println("[INFO] Total de linhas atualizadas: " + rowsUpdated);
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao atualizar conta: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Conta conta) throws Exception {
        System.out.println("[INFO] Iniciando método delete para conta ID: " + conta.getNumero());
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement stmtExcluir = connection.prepareStatement(delete)) {

            System.out.println("[DEBUG] Conexão estabelecida.");
            System.out.println("[DEBUG] Preparando instrução SQL: " + delete);

            stmtExcluir.setLong(1, conta.getNumero());

            System.out.println("[DEBUG] Executando instrução...");

            int rowsDeleted = stmtExcluir.executeUpdate();

            System.out.println("[INFO] Total de linhas excluídas: " + rowsDeleted);
        } catch (SQLException e) {
            System.err.println("[ERROR] Erro ao excluir conta: " + e.getMessage());
            throw e;
        }
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
