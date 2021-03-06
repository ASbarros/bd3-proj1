package Facade;

import DAO.AccountDAO;
import DAO.ExtractDAO;
import DAO.Factory;
import Model.AccountModel;
import Model.ExtractModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class OperationAccount {

    public static void bankDraft(AccountModel account, double val) {
        if (account.getBalance() >= val) {
            ExtractModel extract = new ExtractModel();
            extract.setDescription("Saque");
            extract.setType(0);
            extract.setValue(val);
            extract.setDate(new Date());
            extract.setAccount(account);
            ExtractDAO daoExtract = new ExtractDAO();
            daoExtract.insert(extract);
            account.setBalance(account.getBalance() - val);
            AccountDAO daoAccount = new AccountDAO();
            daoAccount.update(account);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public static void deposit(AccountModel account, double val) {
        if (val > 0) {
            ExtractModel extract = new ExtractModel();
            extract.setDescription("Deposito");
            extract.setType(1);
            extract.setValue(val);
            extract.setDate(new Date());
            extract.setAccount(account);
            ExtractDAO daoExtract = new ExtractDAO();
            daoExtract.insert(extract);
            account.setBalance(account.getBalance() + val);
            AccountDAO daoAccount = new AccountDAO();
            daoAccount.update(account);
        } else {
            System.out.println("Deposito tem que ter valor válido!");
        }
    }

    public static void transfer(AccountModel account1, AccountModel account2, double val) {
        if (val > 0 && account1.getBalance() > val) {
            ExtractModel extract1 = new ExtractModel();
            extract1.setDescription("transferencia");
            extract1.setType(1);
            extract1.setValue(val);
            extract1.setDate(new Date());
            extract1.setAccount(account1);
            ExtractModel extract2 = new ExtractModel();
            extract2.setDescription("transferencia");
            extract2.setType(0);
            extract2.setValue(val);
            extract2.setDate(new Date());
            extract2.setAccount(account2);
            ExtractDAO daoExtract = new ExtractDAO();
            daoExtract.insert(extract1);
            daoExtract.insert(extract2);
            account1.setBalance(account1.getBalance() - val);
            account2.setBalance(account2.getBalance() + val);
            AccountDAO daoAccount = new AccountDAO();
            daoAccount.update(account1);
            daoAccount.update(account2);
        } else {
            System.out.println("Deposito tem que ter valor válido!");
        }
    }

    public static void income(AccountModel account) {
        ExtractModel extract = new ExtractModel();
        extract.setDescription("Rendimento");
        extract.setType(1);
        extract.setValue(0.10);
        extract.setDate(new Date());
        extract.setAccount(account);
        ExtractDAO daoExtract = new ExtractDAO();
        daoExtract.insert(extract);
        account.setBalance(account.getBalance() + (account.getBalance() * 0.1));
        AccountDAO daoAccount = new AccountDAO();
        daoAccount.update(account);
    }
}
