package com.myproject;

import java.util.Objects;

public class User {

    private int code;
    private String name;
    private String email;

    public User(int code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public User() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        var isEqual = false;
        if (obj instanceof User user) {
            if (this == user)
                isEqual = true;
            if (this.code == user.code && Objects.equals(this.name, user.name)
                    && Objects.equals(this.email, user.email))
                isEqual = true;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return String.format("{'code': %s, 'name': %s, 'email': %s}", this.code, this.name, this.email);
    }

}
