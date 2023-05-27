package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.RoleService;
import com.example.hospitalsystemmanagement.validation.UserValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by bonda on 17.05.2023 21:47
 *
 * @author bonda
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DoctorControllerTest {
    @Autowired
    protected WebApplicationContext context;
    @Mock
    private DoctorService doctorService;
    @Mock
    private CategoryService categoryService;
    @Mock
    private RoleService roleService;
    @InjectMocks
    private DoctorController doctorController;
    private MockMvc mockMvc;
    @MockBean
    private UserValidator newFormValidator;
    private Category category;
    private Category category2;
    private User doctor;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController)
                                 .setViewResolvers(viewResolver)
                                 .build();
        Long doctorId = 1L;
        doctor = new User();
        doctor.setId(doctorId);
        category = new Category();
        category.setCategoryId(1L);
        category.setNameCategory("doctorcategory1");
        category2 = new Category();
        category2.setCategoryId(2L);
        category2.setNameCategory("doctorcategory2");
        category.setCategoryId(1L);
        category2.setCategoryId(2L);
        doctor.setCategory(category);

    }


    @Test
    @WithMockUser(roles = "ADMIN")
    public void testShowAddDoctorForm() throws Exception {
        List<Category> categories = Arrays.asList(
                category, category2);
        when(categoryService.findAll()).thenReturn(categories);
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
        mockMvc.perform(get("/doctors/adddoctor"))
               .andExpect(status().isOk())
               .andExpect(view().name("doctorForm"))
               .andExpect(model().attributeExists("categories"))
               .andExpect(model().attribute("categories", categories))
               .andExpect(model().attributeExists("doctor"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testAddDoctorWithValidData() throws Exception {
        when(newFormValidator.supports(any())).thenReturn(true);
        doNothing().when(newFormValidator).validate(any(), any());
        doNothing().when(doctorService).save(any());

        mockMvc.perform(post("/doctors/adddoctoru")
                                .param("firstName", "Test")
                                .param("lastName", "Testov")
                                .param("email", "Test.Testov@example.com")
                                .param("password", "password123"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/doctors/list"));
    }

    @Test
    public void testShowEditDoctorForm() throws Exception {
        List<Category> categories = Arrays.asList(
                category, category2);

        when(doctorService.findById(doctor.getId())).thenReturn(doctor);
        when(categoryService.findAll()).thenReturn(categories);

        mockMvc.perform(get("/doctors/editdoctor/{id}", doctor.getId()))
               .andExpect(status().isOk())
               .andExpect(view().name("doctorEditForm"))
               .andExpect(model().attributeExists("editedDoctor"))
               .andExpect(model().attributeExists("categories"))
               .andReturn();
    }

    @Test
    public void testEditDoctor() throws Exception {
        BindingResult result = mock(BindingResult.class);

        when(doctorService.findById(doctor.getId())).thenReturn(doctor);
        when(categoryService.findById(doctor.getCategory().getCategoryId())).thenReturn(doctor.getCategory());
        when(result.hasErrors()).thenReturn(false);

        mockMvc.perform(post("/doctors/editsave/{id}", doctor.getId())
                                .flashAttr("editedDoctor", doctor)
                                .requestAttr("result", result))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/doctors/list"))
               .andReturn();

        verify(doctorService, times(1)).save(doctor);
    }
}



















