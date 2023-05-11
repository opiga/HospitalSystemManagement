package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

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
    private UserService userService;
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        User signupUser = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "First Name must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty", "Last Name must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirth.empty", "Date of birth must not be empty.");
        String firstName = signupUser.getFirstName();
        if ((firstName.length()) > 15) {
            errors.rejectValue("firstName", "firstName.tooLong", "firstName must not more than 15 characters.");
        }
        String lastName = signupUser.getLastName();
        if ((lastName.length()) > 15) {
            errors.rejectValue("lastName", "lastName.tooLong", "lastName must not more than 15 characters.");
        }

        Pattern patternPhone = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");
        Matcher matcherPhone = patternPhone.matcher(signupUser.getPhoneNumber());
        if (!matcherPhone.matches()) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid", "Invalid phone number format");
        }

        Pattern patternEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcherEmail = patternEmail.matcher(signupUser.getEmail());
        if (!matcherEmail.matches()) {
            errors.rejectValue("email", "email.invalid", "Invalid email format");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty", "Username must not be empty.");
        String username = signupUser.getUsername();
        if ((username.length()) > 15) {
            errors.rejectValue("username", "username.tooLong", "Username must not more than 15 characters.");
        }
        if (userService.loadUserByUsername(username)!=null) {
            errors.rejectValue("username", "username", "Username with the same name already exists.");
        }


//        (?=.*[0-9]) - строка содержит хотя бы одно число;
//        (?=.*[!@#$%^&*]) - строка содержит хотя бы один спецсимвол;
//        (?=.*[a-z]) - строка содержит хотя бы одну латинскую букву в нижнем регистре;
//        (?=.*[A-Z]) - строка содержит хотя бы одну латинскую букву в верхнем регистре;
//[0-9a-zA-Z!@#$%^&*]{6,} - строка состоит не менее, чем из 6 вышеупомянутых символов.
        Pattern patternPassword = Pattern.compile("/(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g");
        Matcher matcherPassword = patternPassword.matcher(signupUser.getPassword());
        if (!matcherPassword.matches()) {
            errors.rejectValue("password", "password.invalid", "Invalid password format. At least 6 characters. " +
                    " A mixture of both uppercase and lowercase letters.  A mixture of letters and numbers.  Inclusion of at least one special character, e.g., ! @ # ? ].");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(signupUser.getPassword()).equals(signupUser.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "passwordConfirm.passwordDontMatch", "Passwords don't match.");
        }

    }
}
