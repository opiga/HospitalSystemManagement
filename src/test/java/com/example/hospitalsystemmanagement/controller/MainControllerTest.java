package com.example.hospitalsystemmanagement.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by bonda on 17.05.2023 21:47
 *
 * @author bonda
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(mainController)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }


    @Test
    public void testIndex() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("index"));
    }

    @Test
    public void testAccessDenied() throws Exception {
        mockMvc.perform(get("/accessDenied"))
               .andExpect(status().isOk())
               .andExpect(view().name("accessDenied"));
    }

    @Test
    public void testHandleLanguageChange() throws Exception {
        mockMvc.perform(get("/lang")
                                .header("referer", "http://example.com"))
               .andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("http://example.com?lang=en"))
               .andExpect(model().attributeExists("lang"));
    }

}



















