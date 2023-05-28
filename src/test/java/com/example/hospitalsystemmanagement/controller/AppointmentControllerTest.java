package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by bonda on 17.05.2023 21:47
 *
 * @author bonda
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AppointmentControllerTest {
    @Autowired
    protected WebApplicationContext context;
    @Mock
    private AppointmentService appointmentService;
    @InjectMocks
    private AppointmentController appointmentController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }

    @Test
    @WithMockUser(roles = "DOCTOR")
    public void testGetListAppointments() throws Exception {
        List<Appointment> appointments = new ArrayList<>();
        when(appointmentService.findAllAppointedByHospitalCardId(1L)).thenReturn(appointments);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/appointments/list/{hospitalCardId}", 1L))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(view().name("viewAppointments"))
               .andExpect(model().attributeExists("appointments"))
               .andReturn();
    }
}



