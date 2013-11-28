package com.lnu.controller;

import com.lnu.bean.PersonCredentials;
import com.lnu.dao.UserDao;
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
        UserDao.registerUser(user);
        return "login";
    }

}
