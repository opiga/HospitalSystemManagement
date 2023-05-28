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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bonda on 13.05.2023 17:27
 *
 * @author bonda
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", messageSource.getMessage("validation.empty.firstName", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty", messageSource.getMessage("validation.empty.lastName", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirth.empty", messageSource.getMessage("validation.empty.dateOfBirth", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.empty", messageSource.getMessage("validation.empty.address", null, LocaleContextHolder.getLocale()));

        String firstName = user.getFirstName();
        if ((firstName.length()) > 15) {
            errors.rejectValue("firstName", "firstName.tooLong", messageSource.getMessage("validation.moreCharacters.firstName", null, LocaleContextHolder.getLocale()));
        }
        String lastName = user.getLastName();
        if ((lastName.length()) > 15) {
            errors.rejectValue("lastName", "lastName.tooLong", messageSource.getMessage("validation.moreCharacters.lastName", null, LocaleContextHolder.getLocale()));
        }

        Pattern patternPhone = Pattern.compile(ValidatorConstants.PHONE_REGEX);
        Matcher matcherPhone = patternPhone.matcher(user.getPhoneNumber());
        if (!matcherPhone.matches()) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid", messageSource.getMessage("validation.invalidFormat.phoneNumber", null, LocaleContextHolder.getLocale()));
        }

        Pattern patternEmail = Pattern.compile(ValidatorConstants.EMAIL_REGEX);
        Matcher matcherEmail = patternEmail.matcher(user.getEmail());
        if (!matcherEmail.matches()) {
            errors.rejectValue("email", "email.invalid", messageSource.getMessage("validation.invalidFormat.email", null, LocaleContextHolder.getLocale()));
        }
    }
}
