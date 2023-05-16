package com.example.hospitalsystemmanagement.validation;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by bonda on 13.05.2023 16:21
 *
 * @author bonda
 */
@Component
public class AppointmentValidator implements Validator {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AppointmentService appointment;

    public boolean supports(Class<?> clazz) {
        return Appointment.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Appointment appointment1 = (Appointment) target;

        if (appointment1.getMedications().isEmpty() && appointment1.getProcedures().isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "medications", "field.required", messageSource.getMessage("validation.empty.medications", null, LocaleContextHolder.getLocale()));
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operations", "field.required",  messageSource.getMessage("validation.empty.operations", null, LocaleContextHolder.getLocale()));
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "procedures", "field.required", messageSource.getMessage("validation.empty.procedures", null, LocaleContextHolder.getLocale()));
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "date.empty", messageSource.getMessage("validation.empty.date", null, LocaleContextHolder.getLocale()));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nurse", "nurse.empty", messageSource.getMessage("validation.empty.nurse", null, LocaleContextHolder.getLocale()));


        String dateString = appointment1.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        LocalDate currentDate = LocalDate.now();

        if (date != null && date.isBefore(currentDate)) {
            errors.rejectValue("date", "date.invalid",  messageSource.getMessage("validation.date.invalid", null, LocaleContextHolder.getLocale()));
        }

    }
}
