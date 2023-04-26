package com.example.hospitalsystemmanagement.controller;


/**
 * Created by bonda on 07.04.2023 10:34
 *
 * @author bonda
 */

import com.example.hospitalsystemmanagement.entity.Patient;
import com.example.hospitalsystemmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    //
    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //
    @PostMapping("/add")
    public String addPatient(@RequestParam String first, @RequestParam String last) {
        Patient patient = new Patient();
        patient.setFirstName(first);
        patient.setLastName(last);
        patientRepository.save(patient);
        return "Added new customer to repo!";
    }
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewpatient(Model m) {
        List<Patient> list = patientService.getAllPatients();
        m.addAttribute("list", list);
        return "viewpatient";
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }
}