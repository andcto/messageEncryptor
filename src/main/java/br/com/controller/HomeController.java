package br.com.controller;

import br.com.dto.UsersDTO;
import br.com.model.Users;
import br.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(UsersDTO usersDTO)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        Users users = userRepository.findUsersByUsername(usersDTO.getUsername());

        if(users != null && users.getPassword().equals(usersDTO.getPassword())) {
            modelAndView.addObject("user", users);
            modelAndView.addObject("listUsers", userRepository.findAll());
            return modelAndView;
        }

        modelAndView.addObject("mensagem", "Senha incorreta");
        modelAndView.setViewName("login");

        return modelAndView;
    }

}
