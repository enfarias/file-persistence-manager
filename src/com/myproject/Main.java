package com.myproject;

import java.util.Optional;

import static com.myproject.com.myproject.SexEnum.FEMALE;
import static com.myproject.com.myproject.SexEnum.MALE;

import com.myproject.com.myproject.User;
import com.myproject.com.myproject.UserV2;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== Optional not empty ==========");
        System.out.println("");

        Optional<User> optional = Optional.of(new User("Edson", 52, MALE));
        optional.ifPresent(System.out::println);
        System.out.println("");

        System.out.println("============ Optional empty ============");
        System.out.println("");

        Optional<User> optional2 = Optional.ofNullable(null);
        optional2.ifPresent(System.out::println);
        System.out.println("");

        System.out.println("========== Optional orElseGet ==========");
        System.out.println("");

        var newUser = optional.map(user -> new UserV2(user.name(), user.age() + 10, user.sex())).orElseThrow();
        System.out.println(newUser);
        System.out.println("");

        System.out.println(optional.orElse(defaultUser()));
        System.out.println("");

        System.out.println(optional.orElseGet(Main::defaultUser));
        System.out.println("");

        Optional<UserV2> newUser2 = optional.map(Main::toV2Domain);
        System.out.println(newUser2.orElseThrow());
        System.out.println("");

        System.out.println("======= Optional ifPresentOrElse =======");
        System.out.println("");

        int newAge = 22;

        optional.ifPresentOrElse(
                user -> {
                    System.out.printf("User: %s \n", user);
                    user = new User("Edson", newAge, MALE);
                    System.out.printf("User: %s \n", user);
                },
                () -> System.out.println("User not found"));
        System.out.println("");

        System.out.println("=========== Optional orElse ============");
        System.out.println("");

        System.out.println(optional2.orElse(new User("Maria", 22, FEMALE)));
        System.out.println("");

        System.out.println(optional2.orElseThrow(() -> new RuntimeException("User not found")));
        System.out.println("");

        System.out.println("=========================================");
        System.out.println("");

    }

    private static UserV2 toV2Domain(final User user) {
        return new UserV2(user.name(), user.age(), user.sex());
    }

    public static User defaultUser() {
        System.out.println("Buscando valor default...");
        System.out.println("");
        return new User("Amanda", 22, FEMALE);
    }

}