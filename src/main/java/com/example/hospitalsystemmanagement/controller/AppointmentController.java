package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.*;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.PatientService;
import com.example.hospitalsystemmanagement.validation.AppointmentValidator;
import com.example.hospitalsystemmanagement.validation.NewFormValidator;
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
@PreAuthorize("hasRole('DOCTOR')")
public class AppointmentController {
    private DoctorService doctorService;
    private PatientService patientService;
    private HospitalCardService hospitalCardService;
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentValidator appointmentValidator;

    public AppointmentController(PatientService thePatientService, AppointmentService theAppointmentService,
                                 DoctorService theDoctorService,
                                 HospitalCardService theHospitalCardService) {
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
        System.out.println("!!!!!!!!!!!");
        System.out.println(currentUser.getRole());
        System.out.println(currentUser.getUsername());
        System.out.println(currentUser.getRole().getId());

        if (currentUser.getRole().getRoleName().contains(RoleType.DOCTOR.toString())) {
            List<HospitalCard> theHospitalCards = hospitalCardService.findAllByDoctorId(currentUser.getId());
            theModel.addAttribute("hospitalCards", theHospitalCards);
            theModel.addAttribute("doctor", currentUser);
            return "viewHospitalCardsDoctor";
        } else if (currentUser.getRole().getRoleName().contains(RoleType.NURSE.toString())) {
            List<HospitalCard> theHospitalCards = hospitalCardService.findAllByNurseId(currentUser.getId());
            theModel.addAttribute("hospitalCards", theHospitalCards);
            theModel.addAttribute("nurse", currentUser);
            return "viewHospitalCardsNurse";
        }
        System.out.println("@@@@@@@@@@@");
        return "viewHospitalCardsDoctor";
    }

    @GetMapping("/listAppointments/{hospitalCardId}")
    public String getListAppointmentsForCurrentUser(@PathVariable("hospitalCardId") Long hospitalCardId, Model theModel) {
        List<Appointment> theAppointments = appointmentService.findAllByHospitalCardId(hospitalCardId);
        theModel.addAttribute("appointments", theAppointments);

//        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(currentUser.getId());
//        model.addAttribute("appointments", appointments);
        return "viewAppointments";
    }

    @GetMapping("/addAppointment/{hospitalCardId}/{patientId}/{doctorId}")
    public String showAddAppointmentForm(@PathVariable("hospitalCardId") Long hospitalCardId,@PathVariable("patientId") Long patientId, @PathVariable("doctorId") Long doctorId,
                                         Model model) {
        Appointment newAppointment = new Appointment();
        newAppointment.setDoctor(doctorService.findById(doctorId));
        newAppointment.setPatient(patientService.findById(patientId));
        newAppointment.setHospitalCard(hospitalCardService.findById(hospitalCardId));
        model.addAttribute("appointment", newAppointment);
        List<User> nurses = doctorService.findAllNurses();
        model.addAttribute("nurses", nurses);
        return "appointmentForm";
    }

    @PostMapping("/addAppointment")
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        appointmentValidator.validate(appointment, result);
        if (result.hasErrors()) {
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("nurses", nurses);
            return "appointmentForm";
        }
        appointmentService.save(appointment);
        return "redirect:/appointments/list";
    }
    @GetMapping("/editAppointment/{id}")
    public String showEditAppointmentForm(@PathVariable("id") Long id, Model model) {
        Appointment appointment = appointmentService.findById(id);
        List<User> nurses = doctorService.findAllNurses();
        model.addAttribute("editedAppointment", appointment);
        model.addAttribute("nurses", nurses);
        return "appointmentEditForm";
    }

    @PostMapping("/editsave")
    public String editAppointment(@ModelAttribute("editedAppointment") Appointment appointment,BindingResult result,
                                  Model model) {
        appointmentValidator.validate(appointment, result);
        if (result.hasErrors()) {
            List<User> doctors = doctorService.findAll();
            model.addAttribute("doctors", doctors);
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("nurses", nurses);
            return "hospitalCardEditForm";
        }

        appointmentService.save(appointment);
        return "redirect:/appointments/list";
    }
}
