package com.example.hospitalsystemmanagement.controller;

/**
 * Created by bonda on 17.04.2023 13:59
 *
 * @author bonda
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice
//public class MessageAdvice {
//
//    @ModelAttribute("message")
//    public String message(@Value("${application.message:Hello World}") String message) {
//        return message;
//    }
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(HttpServletRequest request, Exception ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("error", ex.getMessage());
//        modelAndView.setViewName("error");
//        return modelAndView;
//    }
//}
