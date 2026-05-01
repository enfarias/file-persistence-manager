package com.myproject;

import com.myproject.dao.ClientDAO;
import com.myproject.dao.GenericDAO;
import com.myproject.dao.UserDAO;
import com.myproject.domain.ClientDomain;
import com.myproject.domain.UserDomain;

public class Main {

    private static GenericDAO<Integer, UserDomain> userDAO = new UserDAO();

    private static GenericDAO<String, ClientDomain> clientDAO = new ClientDAO();

    public static void main(String[] args) {

        var user = new UserDomain(1, "Edson", 52);
        var User2 = new UserDomain(1, "José", 42);

        System.out.println("=== UserDAO(Início) ===");

        System.out.println(userDAO.count());
        System.out.println(userDAO.save(1, user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.find(d -> d.getId().equals(1)));
        System.out.println(userDAO.find(d -> d.getId().equals(2)));
        System.out.println(userDAO.count());
        System.out.println(userDAO.update(1, User2));
        System.out.println(userDAO.delete(new UserDomain(-1, "", -1)));
        System.out.println(userDAO.delete(user));
        System.out.println(userDAO.findAll());
        System.out.println(userDAO.count());

        System.out.println("=== UserDAO(Fim) ===");

        var client = new ClientDomain("1", "Maria", 32);
        var Client2 = new ClientDomain("1", "Ana", 38);

        System.out.println("=== ClientDAO(Início) ===");

        System.out.println(clientDAO.count());
        System.out.println(clientDAO.save(1, client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.find(d -> d.getId().equals("1")));
        System.out.println(clientDAO.find(d -> d.getId().equals("2")));
        System.out.println(clientDAO.count());
        System.out.println(clientDAO.update("1", Client2));
        System.out.println(clientDAO.delete(new ClientDomain("", "", -1)));
        System.out.println(clientDAO.delete(client));
        System.out.println(clientDAO.findAll());
        System.out.println(clientDAO.count());

        System.out.println("=== ClientDAO(Fim) ===");
    }
}