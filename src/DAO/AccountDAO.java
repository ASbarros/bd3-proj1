package DAO;

import Model.AccountModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO {

    private Connection myConnection;

    public AccountDAO() {
        myConnection = Factory.getConnectionDefult();
    }

    public AccountDAO(Connection cnx) {
        myConnection = cnx;
    }

    public void insert(AccountModel obj) {
        String sql = "insert into account(description, balance) values (?, ?)";

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setString(1, obj.getDesc());
            pst.setDouble(2, obj.getBalance());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro ao salval o objeto: " + e.getMessage());
        }
    }

    public void update(AccountModel obj) {
        String sql = "update account set description = ?, balance = ? where id = ?";
        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.setString(1, obj.getDesc());
            pst.setDouble(2, obj.getBalance());
            pst.setInt(3, obj.getId());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o objeto: " + e.getMessage());
        }
    }

    public void delete(int index) {
        String sql = "delete account where id = " + index;

        try {
            PreparedStatement pst = myConnection.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Erro ao apagar o objeto: " + e.getMessage());
        }

    }

    public AccountModel get(int index) {
        String sql = "select id, description, balance from account where id = ?";

        try {
            PreparedStatement stp = myConnection.prepareStatement(sql);
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
