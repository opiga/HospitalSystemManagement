package com.example.hospitalsystemmanagement.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bonda on 17.04.2023 13:48
 *
 * @author bonda
 */
@Controller
public class InvalidController {

    @RequestMapping("/fail")
    public String fail() {
        throw new IllegalStateException("this endpoint always fail");
    }

}

