package Model;

public class AccountModel {

    public AccountModel() {
    }

    public AccountModel(String desc, double balance) {
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
