package com.example.hospitalsystemmanagement.controller;


import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
import com.example.hospitalsystemmanagement.validation.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bonda on 17.04.2023 13:49
 *
 * @author bonda
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private SignupValidator signupValidator;

    @GetMapping
    public String signup(ModelMap model) {
        User signupUser = new User();
        model.put("userForm", signupUser);
        return "registration";
    }

    @PostMapping
    public String processSignup(@ModelAttribute("userForm") User signupForm, BindingResult result) {
        signupValidator.validate(signupForm, result);
        if (result.hasErrors()) {
            return "registration";
        }
        if (!userService.saveUser(signupForm)){
            return "registration";
        }
        return "signup-success";
    }
}
