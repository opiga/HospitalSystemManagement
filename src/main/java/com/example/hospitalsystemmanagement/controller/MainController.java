package com.example.hospitalsystemmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;


/**
 * Created by bonda on 10.05.2023 11:10
 *
 * @author bonda
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/lang")
    public String handleLanguageChange(HttpServletRequest request, Model model, Locale locale) {
        model.addAttribute("lang", locale.getLanguage());
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
