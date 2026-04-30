package com.myproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.myproject.com.myproject.domain.Contact;
import com.myproject.com.myproject.domain.ContactType;

import static com.myproject.com.myproject.domain.ContactType.EMAIL;
import static com.myproject.com.myproject.domain.ContactType.PHONE;
import static com.myproject.com.myproject.domain.Sex.FEMALE;
import static com.myproject.com.myproject.domain.Sex.MALE;
import com.myproject.com.myproject.domain.User;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(generateUsers());

        // users.sort(Comparator.comparing(User::name));

        // users.forEach(System.out::println);

        var values = users.stream()
                // .filter(user -> user.contacts().size() >= 2)
                // .filter(user -> user.contacts() == null && user.contacts().isEmpty())
                .filter(user -> user.contacts().stream().anyMatch(c -> c.type() == EMAIL))
                .toList();

        // System.out.println("\n=========== Users with at least 2 contacts: ===========
        // \n");
        // System.out.println("\n=============== Users without contacts ================
        // \n");
        System.out.println("\n================ Users who have emails ================ \n");

        values.forEach(System.out::println);

        var values2 = users.stream()
                .flatMap(user -> user.contacts().stream())
                .filter(contact -> contact.type() == PHONE)
                // .filter(contact -> contact.description().contains("gmail"))
                .sorted(Comparator.comparing(Contact::description))
                .map(contact -> String.format("{\n     'description': '%s', \n     'type': '%s'\n}",
                        contact.description(),
                        contact.type()))
                .toList();

        System.out.println("\n=============== Contacts of type PHONE ================ \n");

        values2.forEach(System.out::println);

        var values3 = users.stream()
                .filter(user -> user.sex() == FEMALE)
                .collect(Collectors.toMap(User::name, user -> user));

        System.out.println("\n==================== Female Users ====================== \n");

        values3.forEach((key, value) -> System.out.printf("Key: %s | Value: %s \n", key, value));
    }

    private static List<User> generateUsers() {

        var contacts1 = List.of(
                new Contact("(19)90665-9104", ContactType.PHONE),
                new Contact("joao@gmail.com", ContactType.EMAIL));

        var contacts2 = List.of(
                new Contact("(21)92121-0032", ContactType.PHONE));

        var contacts3 = List.of(
                new Contact("lucas@Outlook.com", ContactType.EMAIL));

        var contacts4 = List.of(
                new Contact("andreia@outlook.com", ContactType.EMAIL),
                new Contact("andreia@gmail.com", ContactType.EMAIL));

        var contacts5 = List.of(
                new Contact("(31)97785-4456", ContactType.PHONE),
                new Contact("(31)92115-0011", ContactType.PHONE));

        var user1 = new User("João", 26, MALE, new ArrayList<>(contacts1));
        var user2 = new User("Maria", 28, FEMALE, new ArrayList<>(contacts2));
        var user3 = new User("Lucas", 19, MALE, new ArrayList<>(contacts3));
        var user4 = new User("Andreia", 40, FEMALE, new ArrayList<>(contacts4));
        var user5 = new User("Vitor", 30, MALE, new ArrayList<>(contacts5));
        var user6 = new User("Bruna", 36, FEMALE, new ArrayList<>());

        return List.of(user1, user2, user3, user4, user5, user6);

    }

}