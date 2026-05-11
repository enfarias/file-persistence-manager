package com.myproject;

import java.io.IOException;

import com.myproject.persistence.FilePersistence;
import com.myproject.persistence.NIOFilePersistence;

public class Main {

    public static void main(String[] args) throws IOException {

        FilePersistence persistence = new NIOFilePersistence("user.csv");

        System.out.println("=======================================");
        System.out.println(persistence.write("Edson;edson@edson.com;26/08/1973;"));
        System.out.println("=======================================");
        System.out.println(persistence.write("Maria;maria@edsomaria.com;12/01/1986;"));
        System.out.println("=======================================");
        System.out.println(persistence.write("Lucas;lucas@lucas.com;08/12/1983;"));
        System.out.println("=======================================");
        System.out.println(persistence.write("George;george@george.com;21/05/1964;"));
        System.out.println("=======================================");
        System.out.println(persistence.write("Joao;joao@joao.com;03/09/1959;"));
        System.out.println("=======================================");
        System.out.println(persistence.write("Ana;ana@ana.com;18/10/1988;"));
        System.out.println("=======================================");
        System.out.println(persistence.findAll());
        System.out.println("=======================================");
        System.out.println(persistence.remove(";maria"));
        System.out.println("=======================================");
        System.out.println(persistence.remove(";joana"));
        System.out.println("=======================================");
        System.out.println(persistence.findAll());
        System.out.println("=======================================");
        System.out.println(persistence.findBy("rge@"));
        System.out.println("=======================================");
        System.out.println(persistence.findBy("@luca"));
        System.out.println("=======================================");
        System.out.println(persistence.replace("26/08/", "Antonio;antonio@antonio.com;22/04/1973;"));
        System.out.println("=======================================");
    }

}