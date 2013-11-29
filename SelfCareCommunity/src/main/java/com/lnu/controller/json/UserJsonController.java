package com.lnu.controller.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnu.bean.PersonCredentials;
/**
 * UserService: igor
 * Date: 11/28/13
 */
@Controller
public class UserJsonController {

    @ResponseBody
    @RequestMapping(value = "/service/user", method = RequestMethod.GET)
    public PersonCredentials getUserData() {
        return new PersonCredentials();
    }
}
