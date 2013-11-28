package com.lnu.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnu.bean.User;
/**
 * UserService: igor
 * Date: 11/28/13
 */
@Controller
public class UserService {

    @ResponseBody
    @RequestMapping(value = "/service/user", method = RequestMethod.GET)
    public User getUserData() {
        return new User();
    }
}
