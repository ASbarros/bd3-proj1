package DAO;

import Model.AccountModel;

import javax.persistence.EntityManager;


public class AccountDAO {
    
    private EntityManager myConnection;
    
    public AccountDAO() {
        myConnection = Factory.getConnectionDefult();
    }
    
    public AccountDAO(EntityManager cnx) {
        myConnection = cnx;
    }
    
    public void insert(AccountModel obj) {
        myConnection.persist(obj);
        myConnection.getTransaction().commit();
    }
    
    public void update(AccountModel obj) {
        myConnection.persist(myConnection.merge(obj));
        myConnection.getTransaction().commit();
    }
    
    public void delete(int index) {
        myConnection.remove(this.get(index));
        
    }
    
    public AccountModel get(int index) {
        return myConnection.find(AccountModel.class, index);
    }
    
}
