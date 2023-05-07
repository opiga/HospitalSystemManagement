package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.PatientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public AppointmentController(PatientService thePatientService, AppointmentService theAppointmentService,
                                 DoctorService theDoctorService,
                                 HospitalCardService theHospitalCardService) {
        hospitalCardService = theHospitalCardService;
        patientService = thePatientService;
        doctorService = theDoctorService;
        appointmentService = theAppointmentService;
    }

    @GetMapping("/list")
    public String getHospitalCardsForCurrentUser(@AuthenticationPrincipal User currentUser, Model theModel) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        List<HospitalCard> theHospitalCards = hospitalCardService.findAllByDoctorId(currentUser.getId());
        theModel.addAttribute("hospitalCards", theHospitalCards);
        theModel.addAttribute("doctor", currentUser);
//        List<Appointment> appointments = appointmentService.getAppointmentsByDoctorId(currentUser.getId());
//        model.addAttribute("appointments", appointments);
        return "viewhospitalcardsDoctor";
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
    public String addAppointment(@ModelAttribute("appointment") Appointment appointment) {
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

    @PostMapping("/editsave/{id}")
    public String editAppointment(@PathVariable("id") Long id, @ModelAttribute("editedAppointment") Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/appointments/list";
    }









}
