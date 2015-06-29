package com.baidu.pikaq.core.test.db.commit.model;

public class User {
    private final String email;
    private final String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User[email=" + email + ", name=" + name + "]";
    }
}
