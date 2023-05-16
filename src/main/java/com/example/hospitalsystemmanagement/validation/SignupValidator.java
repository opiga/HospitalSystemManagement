package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonda on 08.05.2023 12:45
 *
 * @author bonda
 */
@Component
public class SignupValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        User signupUser = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", messageSource.getMessage("validation.empty.firstName", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty", messageSource.getMessage("validation.empty.lastName", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirth.empty", messageSource.getMessage("validation.empty.dateOfBirth", null, LocaleContextHolder.getLocale()));


        LocalDate currentDate = LocalDate.now();
        if ( signupUser.getDateOfBirth()!=null&&signupUser.getDateOfBirth().isAfter(currentDate)) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.invalid",  messageSource.getMessage("validation.dateOfBirth.invalid", null, LocaleContextHolder.getLocale()));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty", messageSource.getMessage("validation.empty.address", null, LocaleContextHolder.getLocale()));
        String firstName = signupUser.getFirstName();
        if ((firstName.length()) > 15) {
            errors.rejectValue("firstName", "firstName.tooLong", messageSource.getMessage("validation.moreCharacters.firstName", null, LocaleContextHolder.getLocale()));
        }
        String lastName = signupUser.getLastName();
        if ((lastName.length()) > 15) {
            errors.rejectValue("lastName", "lastName.tooLong", messageSource.getMessage("validation.moreCharacters.lastName", null, LocaleContextHolder.getLocale()));
        }
        Pattern patternPhone = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
        Matcher matcherPhone = patternPhone.matcher(signupUser.getPhoneNumber());
        if (!matcherPhone.matches()) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid", messageSource.getMessage("validation.invalidFormat.phoneNumber", null, LocaleContextHolder.getLocale()));
        }

        Pattern patternEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcherEmail = patternEmail.matcher(signupUser.getEmail());
        if (!matcherEmail.matches()) {
            errors.rejectValue("email", "email.invalid", messageSource.getMessage("validation.invalidFormat.email", null, LocaleContextHolder.getLocale()));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", messageSource.getMessage("validation.empty.username", null, LocaleContextHolder.getLocale()));
        String username = signupUser.getUsername();
        if ((username.length()) > 15) {
            errors.rejectValue("username", "username.tooLong", messageSource.getMessage("validation.moreCharacters.userName", null, LocaleContextHolder.getLocale()));
        }
        System.out.println(userService.loadUserByUsername(username));
        if (userService.loadUserByUsername(username)!=null) {
            errors.rejectValue("username", "username", messageSource.getMessage("validation.exists.userName", null, LocaleContextHolder.getLocale()));
        }
        Pattern patternPassword = Pattern.compile("(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}");
        Matcher matcherPassword = patternPassword.matcher(signupUser.getPassword());
        if (!matcherPassword.matches()) {
            errors.rejectValue("password", "password.invalid", messageSource.getMessage("validation.invalidFormat.password", null, LocaleContextHolder.getLocale()));
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validation.empty.password", messageSource.getMessage("validation.invalidFormat.password", null, LocaleContextHolder.getLocale()));
        if (!(signupUser.getPassword()).equals(signupUser.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "passwordConfirm.passwordDontMatch", messageSource.getMessage("validation.dontMatch.password", null, LocaleContextHolder.getLocale()));
        }
    }
}
