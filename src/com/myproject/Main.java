package com.myproject;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        GeometricForm geometricForm = null;

        while (true) {

            System.out.println("Escolha a forma geométrica para calcular a área:");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retângulo");
            System.out.println("3 - Círculo");
            System.out.println("4 - Sair do programa");

            option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                geometricForm = createSquare();
            } else if (option == 2) {
                geometricForm = createRetangle();
            } else if (option == 3) {
                geometricForm = createCircle();
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Opção inválida");
                continue;
            }
            System.out.println("O resultado do cálculo da área é: " + geometricForm.getArea());
        }

    }

    private static GeometricForm createSquare() {
        System.out.println("Informe os tamanhos dos lados");
        var side = Double.parseDouble(scanner.nextLine());
        return new Square(side);
    }

    private static GeometricForm createRetangle() {
        System.out.println("Informe a base: ");
        var height = Double.parseDouble(scanner.nextLine());
        System.out.println("Informe a altura: ");
        var base = Double.parseDouble(scanner.nextLine());
        return new Rectangle(height, base);
    }

    private static GeometricForm createCircle() {
        System.out.println("Informe o raio: ");
        var radius = Double.parseDouble(scanner.nextLine());

        return new Circle(radius);
    }

}
