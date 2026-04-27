package com.myproject;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // HashSet não garante nenhuma ordem, enquanto LinkedHashSet usado mais abaixo,
        // mantém a ordem de inserção
        Set<User> users = new HashSet<>();
        users.add(new User(1, "Edson"));
        users.add(new User(2, "Maria"));
        users.add(new User(3, "João"));
        users.add(new User(4, "Ana"));

        // Testa se dois objetos diferentes na memória são "logicamente" iguais, usando
        // Equals e HashCode
        System.out.println(new User(1, "Edson").equals(new User(1, "Edson")));
        System.out.println(new User(1, "Edson").equals(new User(2, "Maria")));

        System.out.println(new User(1, "Edson").hashCode());

        // Retorna true porque o HashSet usa o hashCode para encontrar o "balde"
        // (bucket)
        // onde o objeto estaria e o equals para confirmar a identidade
        System.out.println(users.contains(new User(1, "Edson")));

        // Retorna false porque, embora o ID 2 exista, o nome associado a ele no Set
        // original é "Maria" e não "João"
        System.out.println(users.contains(new User(2, "João")));

        System.out.println("=========================================");

        // LinkedHashSet: Mantém a ordem de inserção.
        Set<User> users2 = new LinkedHashSet<>();
        users2.add(new User(1, "Edson"));
        users2.add(new User(2, "Maria"));
        users2.add(new User(3, "João"));
        users2.add(new User(4, "Ana"));
        users2.add(new User(5, "Anderson"));

        // Os usuários aparecem exatamente na ordem do .add()
        System.out.println(users2);

        // Remove os objetos que coincidem com os fornecidos na lista
        System.out.println(users2.removeAll(List.of(new User(3, "João"), new User(4, "Ana"))));
        System.out.println(users2);

        // Usa uma negação. Remove quem não tem ID maior que 1, ou seja, o Edson (ID 1)
        // é removido
        users2.removeIf(Predicate.not(user2 -> user2.getId() > 1));
        System.out.println(users2);

        System.out.println("=========================================");

        // O TreeSet não usa equals/hashCode para determinar duplicatas, mas sim o
        // Comparator.
        Set<User> users3 = new TreeSet<>(Comparator.comparingInt(User::getId).reversed()); // ordena pelo ID de forma
                                                                                           // decrescente (4, 3, 2, 1).
        users3.add(new User(1, "Edson"));
        users3.add(new User(2, "Maria"));
        users3.add(new User(3, "João"));
        users3.add(new User(4, "Ana"));

        System.out.println(users3);

    }

}
