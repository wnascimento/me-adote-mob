package com.wnascimento.com.me_adote_mob.domain.login.model;


public class UnauthenticatedUser implements Authenticable {
    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public boolean hasEmail() {
        return false;
    }

    @Override
    public boolean hasPassword() {
        return false;
    }

    @Override
    public boolean isLogged() {
        return false;
    }
}