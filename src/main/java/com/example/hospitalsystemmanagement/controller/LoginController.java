package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
//import com.example.hospitalsystemmanagement.validation.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by bonda on 08.05.2023 23:33
 *
 * @author bonda
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private MessageSource messageSource;
//
//    public String getMessage(String code, Object... args) {
//        Locale locale = LocaleContextHolder.getLocale();
//        return messageSource.getMessage(code, args, locale);
//    }

    @GetMapping
    public String signup(ModelMap model) {
        User signupUser = new User();
        model.put("loginForm", signupUser);
        return "login";
    }
    @PostMapping
    public String processSignup(@ModelAttribute("loginForm") User signupForm, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("!!!!!!!!");
            return "login";
        }
        if (!userService.saveUser(signupForm)){
            System.out.println("##########");
            return "login";
        }
        return "index";
    }
}



