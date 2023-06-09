package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.DoctorWithUsers;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
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
@RequestMapping("/doctors")
@PreAuthorize("hasRole('ADMIN')")
public class DoctorController {
    private DoctorService doctorService;
    private CategoryService categoryService;
    private RoleService roleService;
    @Autowired
    private UserValidator newFormValidator;

    public DoctorController(DoctorService theDoctorService, CategoryService categoryService, RoleService roleService) {
        doctorService = theDoctorService;
        this.categoryService = categoryService;
        this.roleService = roleService;
    }


    @GetMapping("/list")
    public String listDoctors(Model theModel) {
        List<DoctorWithUsers> theDoctors = doctorService.findAllWithPatients();
        theModel.addAttribute("doctors", theDoctors);
        return "viewDoctor";
    }

    @GetMapping("/add")
    public String showAddDoctorForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("doctor", new User());
        return "doctorForm";
    }

    @PostMapping("/add")
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

    @GetMapping("/edit/{id}")
    public String showEditDoctorForm(@PathVariable("id") Long id, Model model) {
        User doctor = doctorService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("editedDoctor", doctor);
        model.addAttribute("categories", categories);
        return "doctorEditForm";
    }

    @PostMapping("/edit/{id}")
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
