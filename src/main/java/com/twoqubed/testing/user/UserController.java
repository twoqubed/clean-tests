package com.twoqubed.testing.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = GET)
    public ModelAndView findUser(@RequestParam String userId) {
        try {
            User user = repository.findUser(userId);
            return new ModelAndView("user", "user", user);
        }
        catch (UserNotFoundException e) {
            return new ModelAndView("error");
        }
    }

    @RequestMapping(method = POST)
    public ModelAndView updateUser(@RequestParam User user) {
        repository.updateUser(user);

        if (user == null) {
            return new ModelAndView("error");
        }

        try {
            repository.updateUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("userSaved");
    }
}
