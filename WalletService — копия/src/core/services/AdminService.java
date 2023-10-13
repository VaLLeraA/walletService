package services;

import entities.Admin;
import entities.User;

import java.util.Scanner;

public class AdminService {
    public void registration(Admin admin){
        if(!admin.isRegistered()) {

            System.out.println("Регистрация администратора");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите ваше имя: ");
            admin.setName(scanner.nextLine());
            System.out.print("Введите ваш пароль: ");
            admin.setPassword(scanner.nextLine());
            System.out.println("Регистрация прошла успешно!");
        } else {
            System.out.println("Администратор уже зарегестрирован.");
        }
    }

    public void authorization(Admin admin){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        while (!admin.getName().equals(scanner.nextLine())) {
            System.out.print("Вы ввели неверное имя. Повторите попытку: ");
        }
        System.out.print("Введите ваш пароль: ");
        while (!admin.getPassword().equals(scanner.nextLine())) {
            System.out.print("Вы ввели неверный пароль. Повторите попытку: ");
        }
        System.out.println("Авторизация прошла успешно!");
        admin.setAuthorized(true);
    }
    public void checkActionsHistory(Admin admin, User user){
        if(admin.isAuthorized()==true) {
            System.out.println("История действий пользователя " + user.getName() + " :");
            for (int i = 0; i < user.getUserActions().size(); i++) {
                System.out.println(user.getUserActions().get(i));
            }
        } else {
            System.out.println("Для просмотра действий пользователя администратор должен быть авторизован.");
        }
    }
}
