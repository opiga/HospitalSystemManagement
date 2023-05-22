package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.xml.crypto.Data;
import java.time.LocalDate;

import static junit.framework.TestCase.*;

/**
 * Created by bonda on 17.05.2023 18:52
 *
 * @author bonda
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SignupValidatorTest {

    private SignupValidator signupValidator;

    @Mock
    private MessageSource messageSource;
    @Mock
    private UserService userService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        signupValidator = new SignupValidator(messageSource,userService);

    }

    @Test
    public void testValidSignupUser() {
        User user = new User();
       user.setId(1L);
       user.setFirstName("user");
       user.setLastName("user");
       user.setUsername("userName");
       user.setPassword("145@Asd");
       user.setPhoneNumber("+12587556652");
       user.setEmail("user@gmail.com");
       user.setDateOfBirth( LocalDate.now().minusYears(40));
       user.setAddress("Street 15");
       user.setPasswordConfirm("145@Asd");

        Errors errors = new BeanPropertyBindingResult(user, "user");
        signupValidator.validate(user, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void testInvalidSignupUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("user");
        user.setLastName("");
        user.setUsername("userName");
        user.setPassword("145@Asd");
        user.setPhoneNumber("4555652");
        user.setEmail("usergmail.com");
        user.setDateOfBirth( LocalDate.now().minusYears(40));
        user.setAddress("Street 15");
        user.setPasswordConfirm("1454");
        Errors errors = new BeanPropertyBindingResult(user, "user");
        signupValidator.validate(user, errors);
        assertEquals(4,errors.getErrorCount());
    }

}