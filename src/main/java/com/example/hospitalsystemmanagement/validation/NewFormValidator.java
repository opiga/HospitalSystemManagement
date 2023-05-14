package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonda on 13.05.2023 16:21
 *
 * @author bonda
 */
@Component
public class NewFormValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private HospitalCardService hospitalCard;

    public boolean supports(Class<?> clazz) {
        return HospitalCard.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        HospitalCard hospitalCard = (HospitalCard) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preliminaryDiagnosis", "preliminaryDiagnosis.empty", messageSource.getMessage("validation.empty.pDiagnosis", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctor", "doctor.empty", messageSource.getMessage("validation.empty.doctor", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nurse", "nurse.empty", messageSource.getMessage("validation.empty.nurse", null, LocaleContextHolder.getLocale()));

//
    }

















        }
