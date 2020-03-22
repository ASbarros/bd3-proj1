package Model;

public class AccountModel {

    public AccountModel() {
    }
    
    public AccountModel( String desc, double balance) {
        this.setBalance(balance);
        this.setDesc(desc);
    }

    int id;
    String desc;
    double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
