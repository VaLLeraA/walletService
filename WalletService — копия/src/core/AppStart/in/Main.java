package AppStart.in;

import entities.User;
import services.BankService;

public class Main {
    public static void main(String[] args) {

        BankService bankService = new BankService();
        User user = new User("Valeria", 40000);
        bankService.registration(user);
        bankService.authorization(user);

    }
}