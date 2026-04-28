package com.myproject;

import java.rmi.server.Operation;

import com.myproject.enumeration.OperationEnum;

public class Main {
    public static void main(String[] args) {

        var option = -1;
        while (option != 5) {
            System.out.println("1 - Sum");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiply");
            System.out.println("4 - Division");
            System.out.println("5 - Exit");

            option = Integer.parseInt(System.console().readLine());

            if (option > 5 || option < 1) {
                System.out.println("Invalid option");
                continue;
            }

            if (option == 5)
                break;

            var selectedOption = OperationEnum.values()[option - 1];

            System.out.println("Enter the first number:");
            var value1 = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the second number:");
            var value2 = Integer.parseInt(System.console().readLine());

            var result = selectedOption.getCalculate().apply(value1, value2);

            System.out.printf("%s %s %s = %s \n\n", value1, selectedOption.getSymbol(), value2, result);

        }

    }

}