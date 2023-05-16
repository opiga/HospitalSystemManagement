package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.PatientService;
import com.example.hospitalsystemmanagement.validation.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bonda on 17.04.2023 14:48
 *
 * @author bonda
 */
@Controller
@RequestMapping("/appointments")

public class AppointmentController {
    private DoctorService doctorService;
    private PatientService patientService;
    private HospitalCardService hospitalCardService;
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentValidator appointmentValidator;

    public AppointmentController(PatientService thePatientService, AppointmentService theAppointmentService, DoctorService theDoctorService, HospitalCardService theHospitalCardService) {
        hospitalCardService = theHospitalCardService;
        patientService = thePatientService;
        doctorService = theDoctorService;
        appointmentService = theAppointmentService;
    }

//    @GetMapping("/list")
//    public String getHospitalCardsForCurrentUser(@AuthenticationPrincipal User currentUser, Model theModel) {
//        List<HospitalCard> theHospitalCards = hospitalCardService.findAllByDoctorId(currentUser.getId());
//        theModel.addAttribute("hospitalCards", theHospitalCards);
//        theModel.addAttribute("doctor", currentUser);
////        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(currentUser.getId());
////        model.addAttribute("appointments", appointments);
//        return "viewHospitalCardsDoctor";
//    }

    @PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
    @GetMapping("/list")
    public String getHospitalCardsForCurrentUser(@AuthenticationPrincipal User currentUser, Model theModel) {

        if (currentUser.getRole().getRoleName().equals("doctor")) {
            List<HospitalCard> theHospitalCards = hospitalCardService.findAllByDoctorId(currentUser.getId());
            theModel.addAttribute("hospitalCards", theHospitalCards);
            theModel.addAttribute("doctor", currentUser);
            return "viewHospitalCardsDoctor";
        }
        else if (currentUser.getRole().getRoleName().equals("nurse")) {
            List<HospitalCard> theHospitalCards = hospitalCardService.findAllByNurseId(currentUser.getId());
            theModel.addAttribute("hospitalCards", theHospitalCards);
            theModel.addAttribute("nurse", currentUser);
            return "viewHospitalCardsNurse";
        }
        return "viewHospitalCardsDoctor";
    }

    @PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
    @GetMapping("/listAppointments/{hospitalCardId}")
    public String getListAppointmentsForCurrentUser(@PathVariable("hospitalCardId") Long hospitalCardId, Model theModel) {
        List<Appointment> theAppointments = appointmentService.findAllAppointedByHospitalCardId(hospitalCardId);
        theModel.addAttribute("appointments", theAppointments);

//        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(currentUser.getId());
//        model.addAttribute("appointments", appointments);
        return "viewAppointments";
    }

    @PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
    @GetMapping("/addAppointment/{hospitalCardId}/{patientId}/{doctorId}/{nurseId}")
    public String showAddAppointmentForm(@AuthenticationPrincipal User currentUser, @PathVariable("hospitalCardId") Long hospitalCardId, @PathVariable("patientId") Long patientId, @PathVariable("doctorId") Long doctorId, @PathVariable("nurseId") Long nurseId, Model model) {
        Appointment newAppointment = new Appointment();
        newAppointment.setPatient(patientService.findById(patientId));
        newAppointment.setHospitalCard(hospitalCardService.findById(hospitalCardId));

        if (currentUser.getRole().getRoleName().equals("doctor")) {
            newAppointment.setDoctor(doctorService.findById(doctorId));
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("appointment", newAppointment);
            model.addAttribute("nurses", nurses);
            return "appointmentForm";
        }
        else {
            newAppointment.setNurse(doctorService.findById(nurseId));
            model.addAttribute("appointment", newAppointment);
            return "appointmentFormNurse";
        }
    }

    @PostMapping("/addAppointment")
    public String addAppointment(@AuthenticationPrincipal User currentUser, @ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        appointmentValidator.validate(appointment, result);
        if (result.hasErrors()) {
            if (currentUser.getRole().getRoleName().equals("doctor")) {
                List<User> nurses = doctorService.findAllNurses();
                model.addAttribute("nurses", nurses);
                return "appointmentForm";
            }
            else {
                return "appointmentFormNurse";
            }
        }
        appointmentService.save(appointment);
        return "redirect:/appointments/list";
    }


    @GetMapping("/editAppointment/{id}")
    public String showEditAppointmentForm(@AuthenticationPrincipal User currentUser, @PathVariable("id") Long id, Model model) {
        Appointment appointment = appointmentService.findById(id);
        model.addAttribute("editedAppointment", appointment);
        if (currentUser.getRole().getRoleName().equals("doctor")) {
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("nurses", nurses);
            return "appointmentEditForm";
        }
        else {
            return "appointmentEditFormNurse";
        }
    }

    @PostMapping("/editsave")
    public String editAppointment(@AuthenticationPrincipal User currentUser, @ModelAttribute("editedAppointment") Appointment appointment, BindingResult result, Model model) {
        if (currentUser.getRole().getRoleName().equals("doctor")) {
            appointmentValidator.validate(appointment, result);
            if (result.hasErrors()) {
                List<User> doctors = doctorService.findAll();
                model.addAttribute("doctors", doctors);
                List<User> nurses = doctorService.findAllNurses();
                model.addAttribute("nurses", nurses);
                return "hospitalCardEditForm";
            }
        }

        appointmentService.save(appointment);
        return "redirect:/appointments/list";
    }
}
