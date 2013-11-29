package com.lnu.controller;

import com.lnu.bean.PersonCredentials;
import com.lnu.dao.PersonalCredentialsDao;
import com.lnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String logIn(ModelMap model) {
         model.addAttribute("error", "false");
         return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logOut(ModelMap model) {
        model.addAttribute("error", "false");
        return "login";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@RequestBody PersonCredentials user) {
        userService.registerUser(user);
        return "login";
    }

}
