package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

    /*  private static final String STR_DRIVER = "org.gjt.mm.mysql.Driver";  // definiÃ§Ã£o de qual banco serÃ¡ utilizado
    private static final String DATABASE = "bd3"; // Nome do banco de dados         
    private static final String IP = "127.0.0.1";  // ip de conexao
    private static final String STR_CON = "jdbc:mysql://" + IP + ":3306/" + DATABASE; // string de conexao com o banco de dados
    private static final String USER = "root"; // Nome do usuÃ¡rio
    private static final String PASSWORD = ""; // senha
    private static Connection objConexao = null;*/
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPU");
    private static EntityManager objManager = factory.createEntityManager();

    public Factory() {
        objManager = factory.createEntityManager();
        objManager.getTransaction().begin();
    }

    public static EntityManager getConnectionDefult() {
        return factory.createEntityManager();
    }

    public static EntityManager getConnectionCustom() {
        return factory.createEntityManager();
    }

    public static void closeFactory() {
        objManager.close();
    }
}
