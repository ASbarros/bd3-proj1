package bd3_proj1;

import Control.CntrlAccount;
import DAO.Factory;
import Facade.OperationAccount;
import Model.AccountModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Bd3_proj1 {

    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpaPU");
        EntityManager gerente = fabrica.createEntityManager();
        
        
        gerente.getTransaction().begin();
        
        gerente.persist(new AccountModel());
        
        //OperationAccount.deposit(account, 1000);
        
        gerente.close();
        System.out.println("Fim!");
    }

}
