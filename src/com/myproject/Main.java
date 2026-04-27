package com.myproject;

import java.util.HashMap;
import java.util.Map;

import com.myproject.domain.User;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();

        System.out.println(users.isEmpty());

        users.put("joao@joao.com", new User("João", 22));
        users.put("maria@maria.com", new User("Maria", 32));
        users.put("pedro@pedro.com", new User("Pedro", 18));
        users.put("ana@ana.com", new User("Ana", 40));

        System.out.println(users.isEmpty());
        System.out.println(users);
        System.out.println("================================");

        users.keySet().forEach(System.out::println);
        System.out.println("================================");

        users.values().forEach(System.out::println);
        System.out.println("================================");

        System.out.println(users.containsKey("marcos@marcos.com"));
        System.out.println(users.containsKey("pedro@pedro.com"));
        System.out.println("================================");

        System.out.println(users.remove("maria@maria.com", new User("Maria", 32)));
        System.out.println("================================");

        users.forEach((k, v) -> System.out.printf("key: %s | value %s \n", k, v));
        users.replace("pedro@pedro.com", new User("Pedro", 60));
        users.forEach((k, v) -> System.out.printf("key: %s | value %s \n", k, v));
        System.out.println("================================");

        System.out.println(users.get("joao@joao.com"));
        System.out.println("================================");

        users.merge("ana@ana.com", new User("", -1), (user, user2) -> {
            System.out.println(user);
            System.out.println(user2);
            return user2;
        });
        System.out.println("================================");

    }

}
