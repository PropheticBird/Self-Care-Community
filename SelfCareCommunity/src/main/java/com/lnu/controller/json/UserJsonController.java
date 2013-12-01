package com.lnu.controller.json;

import com.lnu.bean.Persons;
import com.lnu.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lnu.bean.PersonCredentials;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * UserService: igor
 * Date: 11/28/13
 */
@Controller
public class UserJsonController {

    public static final String HIDE_PASSWORD = "******";
    @Resource(name = "userService")
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/service/currentuserdetails", method = RequestMethod.GET)
    public Persons getUserData() {
        Persons userProfile = userService.getUserProfile(getCurrentUserName());
        userProfile.getPersonCredentials().setPassword(HIDE_PASSWORD);
        return userProfile;
    }

    @RequestMapping(value="/service/currentuserdetails", method = RequestMethod.POST)
    public String register(@ModelAttribute Persons person) {
        userService.updateUser(getCurrentUserName(),person);
        return "redirect:/content/profile.html";
    }

    private String getCurrentUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
