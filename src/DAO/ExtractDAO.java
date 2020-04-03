package DAO;

import Model.ExtractModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtractDAO {

    public ExtractDAO() {

    }

    public void insert(ExtractModel obj) {
        Connection connection = Factory.getConnectionDefult();
        String sql = "insert into extract (description, value, type, idAccount) values (?, ?, ?, ?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, obj.getDescription());
            pst.setDouble(2, obj.getValue());
            pst.setInt(3, obj.getType());
            //pst.setDate(4, (Date) obj.getDate().getTime());
            pst.setInt(4, obj.getAccount().getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salval o objeto: " + e.getMessage());
        }
    }

    public void update(ExtractModel obj) {
        Connection connection = Factory.getConnectionDefult();
        String sql = "update extract set description = ?, value = ?, type = ?, idAccount = ? where id = ? ";//perguntar se são esses campos mesmo

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, obj.getDescription());
            pst.setDouble(2, obj.getValue());
            pst.setInt(3, obj.getType());
            pst.setInt(4, obj.getAccount().getId());
            pst.setInt(5, obj.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o objeto: " + e.getMessage());
        }
    }

    public void delete(int index) {
        Connection connection = Factory.getConnectionDefult();
        String sql = "delete extract where id = " + index;

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao apagar o objeto: " + e.getMessage());
        }
    }

    public ExtractModel get(int index) {
        Connection conexao = Factory.getConnectionDefult();
        String sql = "select id, description, value, type, idAccount from extract where id = ?";

        try {
            PreparedStatement stp = conexao.prepareStatement(sql);
            stp.setInt(1, index);
            ResultSet resultado = stp.executeQuery();

            ExtractModel obj = new ExtractModel();

            if (resultado.next()) {
                AccountDAO account = new AccountDAO();
                obj.setId(Integer.parseInt(resultado.getString("id")));
                obj.setDescription(resultado.getString("description"));
                obj.setValue(resultado.getDouble("value"));
                obj.setType(resultado.getInt("type"));
                obj.setAccount(account.get(resultado.getInt("idAccount")));

            }

            return obj;

        } catch (Exception e) {
            System.out.println("Erro ao apagar o objeto: " + e.getMessage());
        }
        return null;
    }
}
