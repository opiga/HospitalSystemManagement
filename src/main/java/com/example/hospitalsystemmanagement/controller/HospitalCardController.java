package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.PatientService;
import com.example.hospitalsystemmanagement.validation.HospitalCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * Created by bonda on 07.04.2023 10:34
 *
 * @author bonda
 */
@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/hospitalcards")
public class HospitalCardController {
    private HospitalCardService hospitalCardService;
    private CategoryService categoryService;
    private DoctorService doctorService;
    private PatientService patientService;
    @Autowired
    private HospitalCardValidator newHospitalCardValidator;

    public HospitalCardController(HospitalCardService theHospitalCardService,
                                  CategoryService theCategoryService, DoctorService theDoctorService
            , PatientService thePatientService) {
        hospitalCardService = theHospitalCardService;
        categoryService = theCategoryService;
        doctorService = theDoctorService;
        patientService = thePatientService;
    }

    @RequestMapping("/")
    public String home(Model m) {
        return "index";
    }


    @GetMapping("/list/{id}")
    public String listHospitalCards(@PathVariable("id") Long patientId, Model theModel) {
        List<HospitalCard> theHospitalCards = hospitalCardService.findAllByPatientId(patientId);
        theModel.addAttribute("hospitalCards", theHospitalCards);
        theModel.addAttribute("hospitalCardPatient", theHospitalCards.get(0).getPatient());
        LocalDate birthDate = theHospitalCards.get(0).getPatient().getDateOfBirth();
        LocalDate currentDate = LocalDate.now();
        theModel.addAttribute("age", Period.between(birthDate, currentDate).getYears());
        return "viewHospitalCards";
    }


    @GetMapping("/add/{id}")
    public String showAddHospitalCardForm(@PathVariable("id") Long patientId, Model model) {
        HospitalCard newHospitalCard = new HospitalCard();
        newHospitalCard.setPatient(patientService.findById(patientId));
        model.addAttribute("newHospitalCard", newHospitalCard);
        List<User> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        List<User> nurses = doctorService.findAllNurses();
        model.addAttribute("nurses", nurses);
        return "hospitalCardAddForm";
    }

    @PostMapping("/add")
    public String addHospitalCard(@ModelAttribute("newHospitalCard") HospitalCard hospitalCard, BindingResult result, Model model) {
        newHospitalCardValidator.validate(hospitalCard, result);
        if (result.hasErrors()) {
            model.addAttribute("newHospitalCard", hospitalCard);
            List<User> doctors = doctorService.findAll();
            model.addAttribute("doctors", doctors);
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("nurses", nurses);
            return "hospitalCardAddForm";
        }
        User findDoctor = doctorService.findById(hospitalCard.getDoctor().getId());
        hospitalCard.setDoctor(findDoctor);
        hospitalCardService.save(hospitalCard);
        return "redirect:/hospitalcards/list/" + hospitalCard.getPatient().getId();
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long hospitalCardId, Model theModel) {
        HospitalCard hospitalCard = hospitalCardService.findById(hospitalCardId);
        theModel.addAttribute("editedHospitalCard", hospitalCard);
        List<User> doctors = doctorService.findAll();
        theModel.addAttribute("doctors", doctors);
        List<User> nurses = doctorService.findAllNurses();
        theModel.addAttribute("nurses", nurses);
        return "hospitalCardEditForm";
    }

    @PostMapping(value = "/edit")
    public String editHospitalCard(@ModelAttribute("editedHospitalCard")
                                   HospitalCard hospitalCard, BindingResult result,
                                   Model model) {
        newHospitalCardValidator.validate(hospitalCard, result);
        if (result.hasErrors()) {
            List<User> doctors = doctorService.findAll();
            model.addAttribute("doctors", doctors);
            List<User> nurses = doctorService.findAllNurses();
            model.addAttribute("nurses", nurses);
            return "hospitalCardEditForm";
        }
        User findDoctor = doctorService.findById(hospitalCard.getDoctor().getId());
        User findNurse = doctorService.findById(hospitalCard.getNurse().getId());
        hospitalCard.setDoctor(findDoctor);
        hospitalCard.setNurse(findNurse);
        hospitalCardService.save(hospitalCard);
        return "redirect:/hospitalcards/list/" + hospitalCard.getPatient().getId();
    }
}