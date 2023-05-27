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
import com.example.hospitalsystemmanagement.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bonda on 17.04.2023 14:42
 *
 * @author bonda
 */
@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    private RoleService roleService;
    @Autowired
    private UserValidator newFormValidator;

    public PatientController(PatientService thePatientService, RoleService theRoleService) {
        patientService = thePatientService;
        roleService = theRoleService;
    }

    @GetMapping("/list")
    public String listPatients(Model theModel) {
        List<PatientWithNumberOpenedHospitalCards> thePatients = patientService.findAllWithNumberOpenedHospitalCards();
        theModel.addAttribute("patients", thePatients);
        return "viewPatient";
    }

    @GetMapping("/addpatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new User());
        return "patientForm";
    }

    @PostMapping("/addpatientu")
    public String addPatient(@ModelAttribute("patient") User patient, BindingResult result) {
        newFormValidator.validate(patient, result);
        if (result.hasErrors()) {
            return "patientForm";
        }
        patient.setRole(roleService.findByName("patient"));
        patientService.save(patient);
        return "redirect:/patients/list";
    }

    @GetMapping(value = "/editpatient/{id}")
    public String edit(@PathVariable("id") Long patientId, Model m) {
        User patient = patientService.findById(patientId);
        m.addAttribute("patient", patient);
        return "patientEditForm";
    }

    @PostMapping(value = "/editsave")
    public String editsave(@ModelAttribute("patient") User patient) {
        patientService.save(patient);
        return "redirect:/patients/list";
    }
}