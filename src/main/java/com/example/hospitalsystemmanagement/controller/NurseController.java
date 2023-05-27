package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.NurseService;
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
 * Created by bonda on 17.04.2023 14:48
 *
 * @author bonda
 */
@Controller
@RequestMapping("/nurses")
@PreAuthorize("hasRole('ADMIN')")
public class NurseController {
    private NurseService nurseService;
    private RoleService roleService;
    @Autowired
    private UserValidator newUserValidator;

    public NurseController(NurseService theNurseService, RoleService roleService) {
        nurseService = theNurseService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String listNurses(Model theModel) {
        List<User> theNurses = nurseService.findAll();
        theModel.addAttribute("nurses", theNurses);
        return "viewNurse";
    }

    @GetMapping("/addNurse")
    public String showAddNurseForm(Model model) {
        model.addAttribute("nurse", new User());
        return "nurseForm";
    }

    @PostMapping("/addNurseU")
    public String addNurse(@ModelAttribute("nurse") User nurse, BindingResult result, Model model) {
        newUserValidator.validate(nurse, result);
        if (result.hasErrors()) {
            return "nurseForm";
        }
        nurse.setRole(roleService.findByName("nurse"));
        nurseService.save(nurse);
        return "redirect:/nurses/list";
    }

    @GetMapping("/editNurse/{id}")
    public String showEditDoctorForm(@PathVariable("id") Long id, Model model) {
        User nurse = nurseService.findById(id);
        model.addAttribute("editedNurse", nurse);
        return "nurseEditForm";
    }

    @PostMapping("/editSave")
    public String editDoctor(@ModelAttribute("editedNurse") User nurse, BindingResult result) {
        newUserValidator.validate(nurse, result);
        if (result.hasErrors()) {
            return "nurseEditForm";
        }
        nurseService.save(nurse);
        return "redirect:/nurses/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        nurseService.deleteById(id);
        return "redirect:/nurses/list";
    }
}
