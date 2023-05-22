package com.example.hospitalsystemmanagement.controller;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.service.CategoryService;
import com.example.hospitalsystemmanagement.service.DoctorService;
import com.example.hospitalsystemmanagement.service.HospitalCardService;
import com.example.hospitalsystemmanagement.service.PatientService;
import com.example.hospitalsystemmanagement.validation.HospitalCardValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class HospitalCardControllerTest {

    @Autowired
    protected WebApplicationContext context;
    @Mock
    private HospitalCardService hospitalCardService;
    @Mock
    private CategoryService categoryService;
    @Mock
    private DoctorService doctorService;
    @Mock
    private PatientService patientService;

    @InjectMocks
    private HospitalCardController hospitalCardController;

    private MockMvc mockMvc;

    @MockBean
    private HospitalCardValidator newHospitalCardValidator;
    private HospitalCard hospitalCard;
    private User patient;
    private HospitalCard hospitalCard2;
    private User doctor1;
    private User doctor2;
    private User nurse1;
    private User nurse2;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".jsp");
        mockMvc = MockMvcBuilders.standaloneSetup(hospitalCardController).setViewResolvers(viewResolver).build();

        hospitalCard = new HospitalCard();
        hospitalCard.setHospitalCardId(1L);
        hospitalCard.setPreliminaryDiagnosis("diagnosis");
        patient = new User();
        patient.setId(1L);
        patient.setFirstName("testPatient");
        patient.setDateOfBirth(LocalDate.now().minusYears(40));
        hospitalCard.setPatient(patient);
        hospitalCard2 = new HospitalCard();
        hospitalCard2.setHospitalCardId(3L);
        hospitalCard2.setPreliminaryDiagnosis("diagnosis");
        hospitalCard2.setPatient(patient);
        doctor1 = new User();
        doctor1.setId(1L);
        hospitalCard.setDoctor(doctor1);
        doctor2 = new User();
        doctor2.setId(2L);
        nurse1 = new User();
        nurse1.setId(3L);
        nurse2 = new User();
        nurse2.setId(2L);
        hospitalCard.setNurse(nurse1);
    }


    @Test
    public void testListHospitalCards() throws Exception {
        List<HospitalCard> hospitalCards = new ArrayList<>();
        hospitalCards.add(hospitalCard);
        hospitalCards.add(hospitalCard);
        when(hospitalCardService.findAllByPatientId(anyLong())).thenReturn(hospitalCards);
        mockMvc.perform(get("/hospitalcards/list/{id}", 1L)).andExpect(status().isOk()).andExpect(view().name("viewHospitalCards")).andExpect(model().attributeExists("hospitalCards", "hospitalCardPatient", "age")).andReturn();
        verify(hospitalCardService).findAllByPatientId(1L);
    }

    @Test
    public void testShowAddHospitalCardForm() throws Exception {
        when(patientService.findById(patient.getId())).thenReturn(patient);
        List<User> doctors = new ArrayList<>();
        doctors.add(doctor2);
        doctors.add(doctor1);
        when(doctorService.findAll()).thenReturn(doctors);
        List<User> nurses = new ArrayList<>();
        nurses.add(nurse1);
        nurses.add(nurse2);
        when(doctorService.findAllNurses()).thenReturn(nurses);
        mockMvc.perform(get("/hospitalcards/addhospitalcard/{id}", patient.getId())).andExpect(status().isOk()).andExpect(view().name("hospitalCardAddForm")).andExpect(model().attributeExists("newHospitalCard", "doctors", "nurses")).andReturn();
        verify(patientService).findById(patient.getId());
        verify(doctorService).findAll();
        verify(doctorService).findAllNurses();
    }


    @Test
    public void testAddHospitalCard() throws Exception {
        BindingResult bindingResult = new BeanPropertyBindingResult(hospitalCard, "newHospitalCard");
        mockMvc.perform(post("/addNewHospitalCard")
                                .flashAttr("newHospitalCard", hospitalCard)
                                .flashAttr("result", bindingResult))
               .andExpect(status().is4xxClientError())
               .andReturn();
    }

    @Test
    public void testEdit() throws Exception {
        List<User> doctors = new ArrayList<>();
        doctors.add(doctor1);
        doctors.add(doctor2);
        List<User> nurses = new ArrayList<>();
        nurses.add(nurse1);
        nurses.add(nurse2);
        when(hospitalCardService.findById(anyLong())).thenReturn(hospitalCard);
        when(doctorService.findAll()).thenReturn(doctors);
        when(doctorService.findAllNurses()).thenReturn(nurses);
        mockMvc.perform(get("/hospitalcards/edit/{id}", 1L)).andExpect(status().isOk()).andExpect(view().name("hospitalCardEditForm")).andExpect(model().attributeExists("editedHospitalCard")).andExpect(model().attribute("editedHospitalCard", hospitalCard)).andExpect(model().attributeExists("doctors")).andExpect(model().attribute("doctors", doctors)).andExpect(model().attributeExists("nurses")).andExpect(model().attribute("nurses", nurses)).andReturn();
        verify(hospitalCardService).findById(anyLong());
        verify(doctorService).findAll();
        verify(doctorService).findAllNurses();
    }

    @Test
    public void testEditHospitalCard() throws Exception {
        BindingResult bindingResult = new BeanPropertyBindingResult(hospitalCard, "hospitalCard");

        when(doctorService.findAll()).thenReturn(new ArrayList<>());
        when(doctorService.findAllNurses()).thenReturn(new ArrayList<>());

        mockMvc.perform(post("/hospitalcards/editsave").flashAttr("editedHospitalCard", hospitalCard).flashAttr("org.springframework.validation.BindingResult.editedHospitalCard", bindingResult)).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/hospitalcards/list/" + hospitalCard.getPatient().getId())).andReturn();
    }


}



















