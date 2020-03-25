package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factory {

    private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definiÃ§Ã£o de qual banco serÃ¡ utilizado
    private static final String DATABASE = "bd3"; // Nome do banco de dados         
    private static final String IP = "127.0.0.1";  // ip de conexao
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuÃ¡rio
    private static final String PASSWORD = ""; // senha
    private static Connection objConexao = null;

    public Factory() {
        try {
            Class.forName(STR_DRIVER);
            try {
                objConexao = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("deu certo");
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado: " + e.getMessage();
            System.out.println(errorMsg);
        }
    }

    public static Connection getConnectionDefult() {
        if (objConexao == null) {
            Factory KEEPCONNECTION = new Factory();
        }
        return objConexao;
    }

    public static Connection getConnectionCustom() {
        Connection cnx = null;
        try {
            Class.forName(STR_DRIVER);
            cnx = DriverManager.getConnection(STR_CON, USER, PASSWORD);
            cnx.setAutoCommit(false);
            cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO AO GERAR NOVA CONEXAO: " + ex.getMessage());
        }
        return null;
    }
}
