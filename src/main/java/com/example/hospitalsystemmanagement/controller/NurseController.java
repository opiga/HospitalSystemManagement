package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.DoctorWithUsers;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.RoleService;
import com.example.hospitalsystemmanagement.validation.NewUserValidator;
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

    private DoctorService doctorService;
    private CategoryService categoryService;
    private RoleService roleService;

    @Autowired
    private NewUserValidator newFormValidator;

    public  NurseController(DoctorService theDoctorService, CategoryService categoryService, RoleService roleService) {
        doctorService = theDoctorService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String listNurses(Model theModel) {
        List<DoctorWithUsers> theDoctors = doctorService.findAllWithPatients();
        theModel.addAttribute("doctors", theDoctors);
        return "viewDoctor";
    }

    @GetMapping("/adddoctor")
    public String showAddDoctorForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("doctor", new User());
        return "doctorForm";
    }

    @PostMapping("/adddoctoru")
    public String addDoctor(@ModelAttribute("doctor") User doctor, BindingResult result, Model model) {
        newFormValidator.validate(doctor, result);
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "doctorForm";
        }
        doctor.setRole(roleService.findById(5L));
        doctorService.save(doctor);
        return "redirect:/doctors/list";
    }

    @GetMapping("/editdoctor/{id}")
    public String showEditDoctorForm(@PathVariable("id") Long id, Model model) {
        User doctor = doctorService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("editedDoctor", doctor);
        model.addAttribute("categories", categories);
        return "doctorEditForm";
    }

    @PostMapping("/editsave/{id}")
    public String editDoctor(@PathVariable("id") Long id, @ModelAttribute("editedDoctor") User doctor,BindingResult result,Model model) {
        newFormValidator.validate(doctor, result);
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            model.addAttribute("categories", categories);
            return "doctorEditForm";
        }
        Category category = categoryService.findById(doctor.getCategory().getCategoryId());
        doctor.setCategory(category);
        doctorService.save(doctor);
        return "redirect:/doctors/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        doctorService.deleteById(id);
        return "redirect:/doctors/list";
    }
}
