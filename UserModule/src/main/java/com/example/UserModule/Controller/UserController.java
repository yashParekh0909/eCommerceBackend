package com.example.UserModule.Controller;

import com.example.UserModule.Entity.UserModule;
import com.example.UserModule.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/login")
//    public @ResponseBody Object login(@RequestParam("username") String emailId, @RequestParam String password){
//        return userService.login(emailId,password);
//    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Boolean signup(@RequestBody UserModule user){

        Boolean status = userService.signup(user);
        return status;
    }

}
