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

    public static void BankDraft(AccountModel account, double val) {
        if (account.getBalance() >= val) {
            Connection cnx = Factory.getConnectionCustom();
            try {
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

                cnx.commit();
            } catch (SQLException e) {
                System.err.println("Erro ao realizar saque: " + e.getMessage());
                try {
                    cnx.rollback();
                } catch (SQLException er) {
                    System.out.println("erro : " + er.getMessage());
                }
            }
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
