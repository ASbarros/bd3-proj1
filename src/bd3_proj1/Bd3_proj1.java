package bd3_proj1;

import Model.AccountModel;

public class Bd3_proj1 {

    public static void main(String[] args) {
        System.out.println("init");
        AccountModel c = new AccountModel();
        c.setId(0);
        c.setDesc("conta");
        c.setBalance(50000);
    }

}
