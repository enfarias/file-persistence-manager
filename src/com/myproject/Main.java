package com.myproject;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        var user = new User(1, "John Doe", "john.doe@example.com");
        users.add(user);
        users.add(new User(2, "Jane Doe", "jane.doe@example.com"));
        users.add(new User(3, "Bob Smith", "bob.smith@example.com"));

        System.out.println(users);
        System.out.println(users.contains(user));
        System.out.println(users.contains(new User(3, "Bob Smith", "bob.smith@example.com")));
        System.out.println(users.remove(1));
        System.out.println(new User(1, "John Doe", "john.doe@example.com"));
        System.out.println(new User(1, "John Doe", "john.doe@example.com")
                .equals(new User(1, "John Doe", "john.doe@example.com")));

        var arrayStart = OffsetDateTime.now();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            arrayList.add(i);
        }
        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vector = new Vector<>();
        for (int i = 0; i < 100_000_000; i++) {
            vector.add(i);
        }
        System.out.println(Duration.between(vectorStart, OffsetDateTime.now()).toMillis());

        var linkedStart = OffsetDateTime.now();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100_000_000; i++) {
            linkedList.add(i);
        }
        System.out.println(Duration.between(linkedStart, OffsetDateTime.now()).toMillis());
    }

}
