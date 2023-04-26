package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Patient;
import com.example.hospitalsystemmanagement.service.PatientService;
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
@RequestMapping("/doctors")
public class DoctorController {

    private PatientService patientService;

    public DoctorController(PatientService thePatientService) {
        patientService = thePatientService;
    }
    @RequestMapping("/")
    public String home(Model m) {
        return "index";
    }

    @GetMapping("/list")
    public String listPatients(Model theModel) {
        List<Patient> thePatients = patientService.findAll();
        theModel.addAttribute("patients", thePatients);
        return "viewpatient";
    }

    @GetMapping("/addpatient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientform";
    }

    @PostMapping("/addpatientu")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.save(patient);
        return "redirect:/patients/list";
    }

    //edit patient from patient list
    @RequestMapping(value = "/editpatient/{patientId}")
    public String edit(@PathVariable("patientId") Integer patientId, Model m) {
        Patient patient = patientService.findById(patientId);
        m.addAttribute("patient", patient);
        return "patienteditform";
    }

    @PostMapping(value = "/editsave")
    public String editsave(@ModelAttribute("patient") Patient patient) {
        patientService.save(patient);
        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/delete/{patientId}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer patientId) {
        patientService.deleteById(patientId);
        return "redirect:/patients/list";
    }
}
