package DAO;

import Model.ExtractModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;

public class ExtractDAO {

    private EntityManager myConnection;

    public ExtractDAO() {
        myConnection = Factory.getConnectionDefult();

    }

    public void insert(ExtractModel obj) {
        myConnection.getTransaction().begin();
        myConnection.persist(obj);
        myConnection.getTransaction().commit();
    }

    public void update(ExtractModel obj) {
        myConnection.persist(obj);
        myConnection.getTransaction().commit();
    }

    public void delete(int index) {
        myConnection.remove(this.get(index));
    }

    public ExtractModel get(int index) {
        return myConnection.find(ExtractModel.class, index);
    }
}
