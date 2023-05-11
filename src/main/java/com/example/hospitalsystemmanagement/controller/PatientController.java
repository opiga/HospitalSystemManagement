package com.example.hospitalsystemmanagement.controller;


/**
 * Created by bonda on 07.04.2023 10:34
 *
 * @author bonda
 */


import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.PatientWithNumberOpenedHospitalCards;
import com.example.hospitalsystemmanagement.service.PatientService;
import com.example.hospitalsystemmanagement.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;
    private RoleService roleService;

    public PatientController(PatientService thePatientService, RoleService theRoleService) {
        patientService = thePatientService;
        roleService = theRoleService;
    }

//    @RequestMapping("/")
//    public String home(Model m) {
//        return "index";
//    }


    @GetMapping("/list")
    public String listPatients(Model theModel) {
        List<PatientWithNumberOpenedHospitalCards> thePatients = patientService.findAllWithNumberOpenedHospitalCards();
        theModel.addAttribute("patients", thePatients);
        return "viewpatient";
    }

    @GetMapping("/addpatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new User());
        return "patientform";
    }

    @PostMapping("/addpatientu")
    public String addPatient(@ModelAttribute("patient") User patient) {
        patient.setRole(roleService.findByName("patient"));
        patientService.save(patient);
        return "redirect:/patients/list";
    }

    @GetMapping(value = "/editpatient/{id}")
    public String edit(@PathVariable("id") Long patientId, Model m) {
        User patient = patientService.findById(patientId);
        m.addAttribute("patient", patient);
        return "patienteditform";
    }

    @PostMapping(value = "/editsave")
    public String editsave(@ModelAttribute("patient") User patient) {
        patientService.save(patient);
        return "redirect:/patients/list";
    }

//    @GetMapping(value = "/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        patientService.deleteById(id);
//        return "redirect:/patients/list";
//    }

}