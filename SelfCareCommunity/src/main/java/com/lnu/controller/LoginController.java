package com.lnu.controller;

import com.lnu.bean.PersonCredentials;
import com.lnu.dao.PersonalCredentialsDao;
import com.lnu.service.UserService;
import com.lnu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
@Controller
public class LoginController {

    @Resource(name = "userService")
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

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, @ModelAttribute PersonCredentials user) {
        userService.registerUser(user);
        login(request,user.getUserName(),user.getPassword());
        return "redirect:content/profile.html";
    }

    public void login(HttpServletRequest request, String userName, String password)
    {
        Authentication auth= new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList(new SimpleGrantedAuthority(UserServiceImpl.ROLE_USER)));
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);
        // Create a new session and add the security context.
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    }

}
