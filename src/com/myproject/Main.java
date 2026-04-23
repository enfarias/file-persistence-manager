package com.myproject;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", 21),
                new User("Bob", 32),
                new User("Charlie", 44));

        /*
         * users.forEach((User user) -> {
         * System.out.println(user);
         * 
         * });
         */
        users.forEach(System.out::println);
    }
}
