package Control;

import DAO.AccountDAO;
import Facade.OperationAccount;
import Model.AccountModel;

public class CntrlAccount {

    public static void save(String data[]) {
        AccountModel account = AccountModel.parseAccount(data);
        AccountDAO dao = new AccountDAO();
        if (account.getId() > 0) {
            dao.insert(account);
        } else {
            dao.update(account);
        }
    }
    
    public static void delete(int key) {
        AccountDAO dao = new AccountDAO();
        dao.delete(key);
    }
    
    public static String[] get(int key){
        AccountDAO dao  = new AccountDAO();
        AccountModel account = dao.get(key);
        return account.toArray();
    }
    
    public static void BankDraft(int idAccount, double val){
        AccountDAO daoAccount = new AccountDAO();
        AccountModel account = daoAccount.get(idAccount);
        
        OperationAccount.BankDraft(account, val);
    }
}
