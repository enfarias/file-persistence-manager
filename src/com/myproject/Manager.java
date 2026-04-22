package com.myproject;

public non-sealed class Manager extends Employee {

    private String login;

    private String password;

    private Double commission;

    public Manager(String code, String name, String address, int age, Double salary, String login, String password,
            double commission) {
        super(code, name, address, age, salary);
        this.login = login;
        this.password = password;
        this.commission = commission;
    }

    public Manager() {

    }

    @Override
    public String getCode() {
        // return "SL" + super.getCode(); --- Substituído pelo código abaixo, após
        // declarar com protected o code --- IGNORE ---
        return "MN" + this.code;
    }

    @Override
    public double getFullSalary() {
        return this.salary + this.commission;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

}
