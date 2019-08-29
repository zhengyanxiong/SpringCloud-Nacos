package io.agilefast.member.domain;

public class User {

    private int id;
    private String name;
    private Balance balance;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() { }

    public User(int id,Balance balance){
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
