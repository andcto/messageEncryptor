package br.com.controller;


import br.com.model.Users;
import br.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ModelAndView save(Users users){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");
        modelAndView.addObject("user", users);

        userRepository.save(users);

        return modelAndView;
    }

    @GetMapping("/register")
    public String login(){
        return "register";
    }


}
