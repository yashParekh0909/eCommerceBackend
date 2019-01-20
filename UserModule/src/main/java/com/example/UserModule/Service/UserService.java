package com.example.UserModule.Service;

import com.example.UserModule.Entity.UserModule;

public interface UserService {

    /*
     * if(password matched) i.e. passwrod matched with the email and password given.,
     * resp['status'] = true
     * */
    // Object login(String username,String password);

    public Boolean signup(UserModule user);
}
