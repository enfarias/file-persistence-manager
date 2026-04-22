package com.myproject;

public class Main {

    public static void main(String[] args) {

        printEmployee(new Manager());
        printEmployee(new Salesman());

    }

    public static void printEmployee(Employee employee) {

        System.out.printf("=======%s=======\n", employee.getClass().getCanonicalName());

        /*
         * Este bloco comenta o código tradicional de verificação de tipo e casting,
         * que é substituído pela nova sintaxe de pattern matching para instanceof.
         * if (employee instanceof Manager ) {
         * 
         * employee.setCode("M001");
         * employee.setName("Jane Smith");
         * employee.setAddress("456 Elm St");
         * employee.setAge(40);
         * employee.setSalary(80000.0);
         * 
         * ((Manager) employee).setLogin("jsmith");
         * ((Manager) employee).setPassword("password123");
         * ((Manager) employee).setCommission(0.1);
         */

        switch (employee) {
            case Manager manager -> {
                manager.setCode("123");
                manager.setName("John Doe");
                manager.setSalary(5000.0);
                manager.setLogin("jdoe");
                manager.setPassword("password");
                manager.setCommission(0.1);

                System.out.println("Code: " + manager.getCode());
                System.out.println("Employee: " + manager.getName() + ", Salary: " + manager.getSalary());
                System.out.println("Login: " + manager.getLogin() + ", Password: " + manager.getPassword());
                System.out.println("Commission: " + manager.getCommission());

            }
            case Salesman salesman -> {
                salesman.setCode("456");
                salesman.setName("Jane Smith");
                salesman.setSalary(4000.0);
                salesman.setPercentPerSold(0.05);
                salesman.setSoldAmount(1000.0);

                System.out.println("Code: " + salesman.getCode());
                System.out.println("Employee: " + salesman.getName() + ", Salary: " + salesman.getSalary());
                System.out.println("Percent Per Sold: " + salesman.getPercentPerSold());
                System.out.println("Sold Amount: " + salesman.getSoldAmount());
            }

        }

        System.out.println("Full Salary: " + employee.getFullSalary(500.0));
        System.out.println("Full Salary: " + employee.getFullSalary());
        System.out.println("===================================\n");
    }

}
