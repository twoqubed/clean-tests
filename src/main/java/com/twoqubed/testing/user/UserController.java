package com.twoqubed.testing.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = POST)
    public ModelAndView updateUser(@RequestParam User user) {
        return null;
    }

    @RequestMapping(method = GET)
    public ModelAndView findUser(@RequestParam String userId) {
        return null;
    }
}
