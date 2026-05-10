package com.myproject;

import java.io.IOException;

import com.myproject.persistence.FilePersistence;
import com.myproject.persistence.IOFilePersistence;

public class Main {

    public static void main(String[] args) throws IOException {

        FilePersistence persistence = new IOFilePersistence("user.csv");

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
        System.out.println(persistence.remove("joao@"));
        System.out.println("=======================================");
        System.out.println(persistence.remove("06/1922"));
        System.out.println("=======================================");
        System.out.println(persistence.findBy("Maria"));
        System.out.println("=======================================");
        System.out.println(persistence.findBy("ana@"));
        System.out.println("=======================================");
        System.out.println(persistence.findBy("21"));
        System.out.println("=======================================");
        System.out.println(persistence.findBy("59"));
        System.out.println("=======================================");
        System.out.println(persistence.replace(".com;21/05", "Carlos;carlos@carlos.com;22/03/1976;"));
        System.out.println("=======================================");
        System.out.println(persistence.findAll());
        System.out.println("=======================================");

    }

}