package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(){
        return "register";
    }
}
