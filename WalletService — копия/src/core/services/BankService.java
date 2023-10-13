package services;

import entities.ActionOfUser;
import entities.Transaction;
import entities.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankService {

    public void registration(User user){
        if(!user.isRegistered()) {
            System.out.println("Регистрация пользователя");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите ваше имя: ");
            user.setName(scanner.nextLine());
            System.out.print("Введите ваш пароль: ");
            user.setPassword(scanner.nextLine());

            user.setTransactionsHistory(new ArrayList<Transaction>());
            user.setUserActions(new ArrayList<ActionOfUser>());
            user.setRegistered(true);

            System.out.println("Пользователь успешно зарегестрирован!");
            user.getUserActions().add(new ActionOfUser("регистрация"));
        } else {
            System.out.println("Пользователь уже зарегестрирован");
        }
    }

    public void authorization(User user){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        while(!user.getName().equals(scanner.nextLine())){
            System.out.print("Вы ввели неверное имя. Повторите попытку: ");
        }
        System.out.print("Введите ваш пароль: ");
        while (!user.getPassword().equals(scanner.nextLine())){
            System.out.print("Вы ввели неверный пароль. Повторите попытку: ");
        }
        System.out.println("Авторизация прошла успешно!");
        BankService.chooseTransaction(user);
        user.getUserActions().add(new ActionOfUser("авторизация"));
    }

    private static void chooseTransaction(User user){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберете услугу:  \n '1' - снять наличные \n '2' - пополнить баланс \n '3' - проверить баланс \n '4' - посмотреть историю транзакций");
        switch (scanner.nextLine()) {
            case ("1") -> BankService.debit(user);
            case ("2") -> BankService.credit(user);
            case ("3") -> BankService.checkBalance(user);
            case ("4") -> BankService.checkUserTransactions(user);
            default -> {
                System.out.println("Такую услугу мы не предоставляем");
                BankService.continueOrExit(user);
            }
        }
    }
    private static void continueOrExit(User user){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите: \n '1' - если хотите воспользоваться другой услугой \n '2' - если хотите выйти из системы");
        switch (scanner.nextLine()){
            case ("1") -> BankService.chooseTransaction(user);
            case ("2") -> System.out.println("Вы вышли из системы.");
            default -> {
                System.out.println("Варианта с таким номером не сущетвует");
                BankService.continueOrExit(user);
            }
        }
    }
    private static void checkUserTransactions(User user){
        for (int i = 0; i < user.getTransactionsHistory().size(); i++) {
            System.out.println(user.getTransactionsHistory().get(i));
        }
        user.getUserActions().add(new ActionOfUser("просмотр истории транзакций"));
        BankService.continueOrExit(user);
    }
    private static void debit(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числовой идентификатор транзакции: ");
        int idOfTransaction = scanner.nextInt();

        try {
            for (int i = 0; i < user.getTransactionsHistory().size(); i++) {
                if (idOfTransaction == user.getTransactionsHistory().get(i).getId()) {
                    throw new IOException();
                }
            }

            System.out.print("Введите сумму, которую хотите снять: ");
            long amountOfCash = scanner.nextLong();

            if (user.getBalance() > user.getBalance() - amountOfCash) {
                user.setBalance(user.getBalance() - amountOfCash);
                user.getTransactionsHistory().add(new Transaction(idOfTransaction, "снятие средств"));
                System.out.println("Транзакция прошла успешно!");
                BankService.continueOrExit(user);
            } else {
                System.out.println("На вашем счете недостаточно средств");
                BankService.continueOrExit(user);
            }
        } catch (IOException e) {
            System.out.println("Транзакция с таким идентификатором уже существует. Повторите попытку позже. ");
            BankService.continueOrExit(user);
        }
        user.getUserActions().add(new ActionOfUser("снятие средств"));
    }
    private static void credit (User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числовой идентификатор транзакции: ");
        int idOfTransaction = scanner.nextInt();

        try {
            for (int i = 0; i < user.getTransactionsHistory().size(); i++) {
                if (idOfTransaction == user.getTransactionsHistory().get(i).getId()) {
                    throw new IOException();
                }
            }

            System.out.print("Введите сумму пополнения: ");
            user.setBalance(user.getBalance() + scanner.nextLong());
            user.getTransactionsHistory().add(new Transaction(idOfTransaction, "пополнение баланса"));
            System.out.println("Транзакция прошла успешно!");
            BankService.continueOrExit(user);

        } catch (IOException e) {
            System.out.println("Транзакция с таким идентификатором уже существует. Повторите попытку позже. ");
            BankService.continueOrExit(user);
        }
        user.getUserActions().add(new ActionOfUser("пополнение счета"));
    }

    private static void checkBalance(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числовой идентификатор транзакции: ");
        int idOfTransaction = scanner.nextInt();

        try {
            for (int i = 0; i < user.getTransactionsHistory().size(); i++) {
                if (idOfTransaction == user.getTransactionsHistory().get(i).getId()) {
                    throw new IOException();
                }
            }

            user.getTransactionsHistory().add(new Transaction(idOfTransaction, "проверка баланса"));
            System.out.println("Ваш баланс: " + user.getBalance());
            BankService.continueOrExit(user);

        } catch (IOException e) {
            System.out.println("Транзакция с таким идентификатором уже существует. Повторите попытку позже. ");
            BankService.continueOrExit(user);
        }
        user.getUserActions().add(new ActionOfUser("проверка баланса"));
    }
}
