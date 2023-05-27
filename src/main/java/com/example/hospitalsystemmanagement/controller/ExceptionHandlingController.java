package com.example.hospitalsystemmanagement.controller;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bonda on 17.04.2023 14:48
 *
 * @author bonda
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public ModelAndView handleInternalAuthenticationServiceException(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", "An internal error occurred while trying to authenticate the user.");
        return modelAndView;
    }
}