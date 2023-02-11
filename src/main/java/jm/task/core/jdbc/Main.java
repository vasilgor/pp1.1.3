package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {

    //  Создание таблицы User(ов)
    //  Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
    //  Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
    //  Очистка таблицы User(ов)
    //  Удаление таблицы

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

//        userService.createUsersTable();
//        System.out.println("Table create");
//        System.out.println("--------------------");
//        userService.saveUser("Vasilisa", "Gorchakova", (byte) 27);
//        userService.saveUser("Irina", "Gorchakova", (byte) 59);
//        userService.saveUser("Uriy", "Gorchakov", (byte) 54);
//        userService.saveUser("Roman", "Malushev", (byte) 35);
//        System.out.println("4 users saved");
//        System.out.println("--------------------");
//        System.out.println(userService.getAllUsers());
//        System.out.println("--------------------");
//        userService.removeUserById(4);
//        System.out.println("delete user №4");
//        System.out.println("--------------------");
//        System.out.println(userService.getAllUsers());
//        System.out.println("--------------------");
//        userService.cleanUsersTable();
//        System.out.println("Table clean");
//        System.out.println("--------------------");
//        System.out.println(userService.getAllUsers());
//        System.out.println("--------------------");
//        userService.dropUsersTable();
//        System.out.println("Table drop");
    }
}
