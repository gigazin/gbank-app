package com.github.gigazin.gbankapp.gbank;

public class Client {
    private String name;
    private String CPF;

    public Client() {

    }

    public Client(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public String getCPF() {
        return CPF;
    }

}
