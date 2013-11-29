package com.lnu.controller.json;

import com.lnu.bean.Persons;
import com.lnu.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnu.bean.PersonCredentials;

import javax.annotation.Resource;

/**
 * UserService: igor
 * Date: 11/28/13
 */
@Controller
public class UserJsonController {

    @Resource(name = "userService")
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/service/currentuserdetails", method = RequestMethod.GET)
    public Persons getUserData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserProfile(auth.getName());
    }
}
