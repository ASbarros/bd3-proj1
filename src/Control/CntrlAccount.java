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

    public static String[] get(int key) {
        AccountDAO dao = new AccountDAO();
        AccountModel account = dao.get(key);
        return account.toArray();
    }

    public static void bankDraft(int idAccount, double val) {
        AccountDAO daoAccount = new AccountDAO();
        AccountModel account = daoAccount.get(idAccount);

        OperationAccount.bankDraft(account, val);
    }

    public static void deposit(int idAccount, double val) {
        AccountDAO daoAccount = new AccountDAO();
        AccountModel account = daoAccount.get(idAccount);

        OperationAccount.deposit(account, val);
    }
    
    public static void transfer(int idAccount1, int idAccount2, double val) {
        AccountDAO daoAccount = new AccountDAO();
        AccountModel account1 = daoAccount.get(idAccount1);
        AccountModel account2 = daoAccount.get(idAccount2);

        OperationAccount.transfer(account1, account2, val);
    }
     
    public static void income(int idAccount) {
        AccountDAO daoAccount = new AccountDAO();
        AccountModel account = daoAccount.get(idAccount);

        OperationAccount.income(account);
    }
}
