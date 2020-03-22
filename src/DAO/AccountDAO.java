package DAO;

import Model.AccountModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {

    public AccountDAO() {

    }

    public void insert(AccountModel obj) {
        Connection connection = Factory.createConnection();
        String sql = "insert into account(description, balance) values (?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, obj.getDesc());
            pst.setDouble(2, obj.getBalance());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao salval o objeto: " + e.getMessage());
        }
    }

    public void update(AccountModel obj) {
        Connection connection = Factory.createConnection();
        String sql = "update account set description = ?, balance = ? where id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, obj.getDesc());
            pst.setDouble(2, obj.getBalance());
            pst.setInt(3, obj.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o objeto: " + e.getMessage());
        }
    }

    public void delete(int index) {
        Connection connection = Factory.createConnection();
        String sql = "delete account where id = " + index;

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao apagar o objeto: " + e.getMessage());
        }

    }

    public AccountModel get(int index) {
        Connection conexao = Factory.createConnection();
        String sql = "select id, description, balance from account where id = ?";

        try {
            PreparedStatement stp = conexao.prepareStatement(sql);
            stp.setInt(1, index);
            ResultSet resultado = stp.executeQuery();

            AccountModel obj = new AccountModel();

            if (resultado.next()) {
                obj.setId(Integer.parseInt(resultado.getString("id")));
                obj.setDesc(resultado.getString("description"));
                obj.setBalance(resultado.getDouble("balance"));

            }

            return obj;

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
