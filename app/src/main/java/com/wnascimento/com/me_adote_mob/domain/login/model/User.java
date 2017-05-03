package com.wnascimento.com.me_adote_mob.domain.login.model;

public class User implements Authenticable {

    private final String email;
    private final String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean hasEmail() {
        return email != null && !email.isEmpty();
    }

    @Override
    public boolean hasPassword() {
        return password != null && !password.isEmpty();
    }

    @Override
    public boolean isLogged() {
        return hasEmail() && hasPassword();
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }
}