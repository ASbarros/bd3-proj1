package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
    @NamedQuery(name="AccountModel.todas",query = "SELECT a FROM AccountModel a"),
    @NamedQuery(name="AccountModel.saldoMaiorQueZero",query = "SELECT a FROM AccountModel a WHERE a.balance > 0"),
    @NamedQuery(name = "AccountModel.maiorSaldo",query = "SELECT MAX(a.balance) FROM AccountModel a")
})
@Entity
public class AccountModel implements Serializable {

    public AccountModel() {
    }

    public AccountModel(String desc, double balance) {
        this.setBalance(balance);
        this.setDesc(desc);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String description;
    @Column
    double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void parseAccount(AccountModel obj, String data[]) {
        if (data[0].trim().equals("")) {
            obj.setId(0);
        } else {
            obj.setId(Integer.parseInt(data[0]));
        }
        obj.setDesc(data[1]);
        obj.setBalance(Double.parseDouble(data[2]));
    }

    public static AccountModel parseAccount(String data[]) {
        AccountModel account = new AccountModel();
        parseAccount(account, data);

        return account;
    }

    public String[] toArray() {
        String array[] = new String[6];
        array[0] = String.valueOf(this.getId());
        array[1] = this.getDesc();
        array[2] = String.valueOf(this.getBalance());
        return array;
    }

}
