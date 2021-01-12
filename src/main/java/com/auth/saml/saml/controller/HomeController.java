package com.auth.saml.saml.controller;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.SAMLUser;
import com.github.ulisesbocchio.spring.boot.security.saml.user.SAMLUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by victor abidoye on 1/12/2021
 **/
@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView home(@SAMLUser SAMLUserDetails user){
        ModelAndView homeView = new ModelAndView("home");
        homeView.addObject("userId", user.getUsername());
        homeView.addObject("samlAttributes", user.getAttributes());
        return homeView;
    }
}
