package com.example.hospitalsystemmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by bonda on 10.05.2023 11:10
 *
 * @author bonda
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String locale(Locale locale) {

        return "index";
    }
}
