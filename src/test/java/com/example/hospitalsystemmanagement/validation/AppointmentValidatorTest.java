package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by bonda on 17.05.2023 18:52
 *
 * @author bonda
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppointmentValidatorTest {

    private AppointmentValidator appointmentValidator;

    @Mock
    private MessageSource messageSource;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        appointmentValidator = new AppointmentValidator(messageSource);

    }

    @Test
    public void testValidAppointment() {
        Appointment appointment = new Appointment();
        appointment.setMedications("pills");
        appointment.setProcedures("CT");
        LocalDate appointmentDate = LocalDate.now().plusDays(5);
        appointment.setDate(String.valueOf(appointmentDate));
        User nurse = new User();
        nurse.setId(1L);
        appointment.setNurse(nurse);
        Errors errors = new BeanPropertyBindingResult(appointment, "appointment");
        appointmentValidator.validate(appointment, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void testInvalidAppointment() {
        Appointment appointment = new Appointment();
        appointment.setMedications("");
        appointment.setProcedures("");
        LocalDate appointmentDate = LocalDate.now().plusDays(5);
        appointment.setDate(String.valueOf(appointmentDate));
        Errors errors = new BeanPropertyBindingResult(appointment, "appointment");
        appointmentValidator.validate(appointment, errors);
        assertTrue(errors.hasErrors());

    }

}