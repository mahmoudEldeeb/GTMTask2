package com.deeb.gtmtask.models;

public class ContactsModel {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public ContactsModel(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
