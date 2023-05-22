package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.UserService;
import com.example.hospitalsystemmanagement.validation.SignupValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
public class RegistrationControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private SignupValidator signupValidator;

    @InjectMocks
    private RegistrationController registrationController;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }

    @Test
    public void signupTest() throws Exception {
        mockMvc.perform(get("/registration"))
               .andExpect(status().isOk())
               .andExpect(view().name("registration"))
               .andExpect(model().attributeExists("userForm"));

    }


    @Test
    public void testProcessSignupValidation() throws Exception {
        User user = new User();
        user.setPassword("12");
        BindingResult result = new BeanPropertyBindingResult(user, "userForm");
        result.reject("error.code", "Error message");

        mockMvc.perform(post("/registration")
                                .flashAttr("userForm", user)
                                .requestAttr("org.springframework.validation.BindingResult.userForm", result))
               .andExpect(status().isOk())
               .andExpect(view().name("registration"))
               .andExpect(model().attributeExists("userForm"));
    }


}
