package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.RoleService;
import com.example.hospitalsystemmanagement.service.UserService;
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
public class LoginControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private LoginController loginController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(loginController)
                                 .setViewResolvers(viewResolver)
                                 .build();


    }

    @Test
    public void testSignup() throws Exception {
        mockMvc.perform(get("/login"))
               .andExpect(status().isOk())
               .andExpect(view().name("login"))
               .andExpect(model().attributeExists("loginForm"))
               .andReturn();
    }

    @Test
    public void testProcessSignupWithValidUser() throws Exception {
        User validUser = new User();
        BindingResult result = mock(BindingResult.class);
        when(userService.saveUser(validUser)).thenReturn(true);
        mockMvc.perform(post("/login")
                                .flashAttr("loginForm", validUser)
                                .requestAttr("result", result))
               .andExpect(status().isOk())
               .andExpect(view().name("index"))
               .andReturn();
        verify(userService, times(1)).saveUser(validUser);
    }

    @Test
    public void testProcessSignupWithInvalidUser() throws Exception {
        User invalidUser = new User();
        BindingResult result = mock(BindingResult.class);

        when(result.hasErrors()).thenReturn(true);

        mockMvc.perform(post("/login")
                                .flashAttr("loginForm", invalidUser)
                                .requestAttr("result", result))
               .andExpect(status().isOk())
               .andExpect(view().name("login"))
               .andReturn();

    }

}



















