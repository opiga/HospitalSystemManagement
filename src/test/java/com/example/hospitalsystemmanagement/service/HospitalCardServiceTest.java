package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.HospitalCardRepository;
import com.example.hospitalsystemmanagement.service.serviceImpl.HospitalCardServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by bonda on 17.05.2023 10:23
 *
 * @author bonda
 */
@RunWith(MockitoJUnitRunner.class)
public class HospitalCardServiceTest {
    @InjectMocks
    private HospitalCardServiceImpl hospitalCardService;
    @Mock
    private HospitalCardRepository hospitalCardRepository;
    private HospitalCard hospitalCard;
    private HospitalCard hospitalCard2;

    @BeforeEach
    public void setup() {
        hospitalCard = new HospitalCard();
        hospitalCard.setHospitalCardId(1L);
        hospitalCard.setPreliminaryDiagnosis("Astma");
        hospitalCard2 = new HospitalCard();
        hospitalCard2.setHospitalCardId(2L);
        hospitalCard2.setPreliminaryDiagnosis("Bronhit");
    }

    @Test
    public void findAllByPatientIdTest() {
        setup();
        List<HospitalCard> listHospitalCards = new ArrayList<>();
        User patient = new User();
        patient.setId(3L);
        hospitalCard.setPatient(patient);
        hospitalCard2.setPatient(patient);
        listHospitalCards.add(hospitalCard);
        listHospitalCards.add(hospitalCard2);
        when(hospitalCardRepository.findAllByPatientId(patient.getId())).thenReturn(listHospitalCards);
        List<HospitalCard> result = hospitalCardService.findAllByPatientId(patient.getId());
        // Assert the expected results
        assertEquals(2, result.size());
        assertEquals(patient.getId(), result.get(0).getPatient().getId());
        assertEquals(patient.getId(), result.get(1).getPatient().getId());
        verify(hospitalCardRepository, times(1)).findAllByPatientId(patient.getId());
    }

    @Test
    public void getHospitalCardByIdTest() {
        setup();
        Long hospitalCardId = 1L;
        when(hospitalCardRepository.findById(hospitalCardId)).thenReturn(Optional.of(hospitalCard));
        HospitalCard result = hospitalCardService.findById(hospitalCardId);
        assertEquals(hospitalCard, result);
    }
}