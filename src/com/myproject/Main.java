package com.myproject;

import com.myproject.com.myproject.UserDomain;
import com.myproject.dao.GenericDAO;
import com.myproject.domain.UserDAO;

public class Main {

    private static GenericDAO<Integer, UserDomain> dao = new UserDAO();

    public static void main(String[] args) {

        var user = new UserDomain(1, "Edson", 52);

        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.find(d -> d.getId().equals(1)));
        System.out.println(dao.find(d -> d.getId().equals(2)));
        System.out.println(dao.count());
        // System.out.println(dao.update(null);
        System.out.println(dao.delete(new UserDomain(-1, "", -1)));
        System.out.println(dao.delete(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
    }
}