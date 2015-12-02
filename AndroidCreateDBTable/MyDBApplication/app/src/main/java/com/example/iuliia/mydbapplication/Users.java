package com.example.iuliia.mydbapplication;

/**
 * Created by tetiana on 01.12.15.
 */
public class Users {
    
    private int _id;
    private String _username;
    private String _email;
    private String _password;

    public Users(){

    }

    public Users(String _username, String _email, String _password) {
        this._username = _username;
        this._email = _email;
        this._password = _password;
    }


    @Override
    public String toString() {
        return "User [id=" + _id + ", username=" + _username + ", email=" + _email +", password=" + _password
                + "]";
    }


    public String get_username() {
        return _username;
    }

    public String get_email() {
        return _email;
    }

    public String get_password() {
        return _password;
    }


    public void setId(int id) {
        this._id = id;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public void setEmail(String email) {
        this._email = email;
    }


    public void setPassword(String password) {
        this._password = password;
    }
}


