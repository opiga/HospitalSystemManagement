package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Role;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.DoctorRepository;
import com.example.hospitalsystemmanagement.service.serviceImpl.DoctorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class DoctorServiceTest {
    @InjectMocks
    private DoctorServiceImpl doctorService;
    @Mock
    private DoctorRepository doctorRepository;

    @Test
    public void getAllDoctorsTest() {
        List<User> listDoctors = new ArrayList<>();
        User userOne = new User();
        userOne.setFirstName("Alex");
        userOne.setLastName("Smith");
        listDoctors.add(userOne);
        User userTwo = new User();
        userTwo.setFirstName("John");
        userTwo.setLastName("Pit");
        listDoctors.add(userTwo);
        when(doctorRepository.findAll()).thenReturn(listDoctors);
        List<User> result = doctorService.findAll();
        assertEquals(2, result.size());
        assertEquals("Alex", result.get(0).getFirstName());
        assertEquals("Smith", result.get(0).getLastName());
        assertEquals("John", result.get(1).getFirstName());
        assertEquals("Pit", result.get(1).getLastName());
    }

    @Test
    public void getDoctorByIdTest() {
        Long doctorId = 1L;
        User doctor = new User();
        doctor.setFirstName("Alex");
        doctor.setLastName("Smith");
        doctor.setId(doctorId);
        Mockito.when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctor));
        User result = doctorService.findById(doctorId);
        assertEquals(doctor, result);
    }

    @Test
    public void findAllNursesTest() {
        List<User> nurses = new ArrayList<>();
        Role roleNurse = new Role();
        roleNurse.setId(1L);
        roleNurse.setRoleName("nurse");
        User nurse1 = new User();
        nurse1.setId(1L);
        nurse1.setFirstName("Nurse1");
        nurse1.setRole(roleNurse);
        nurses.add(nurse1);
        User nurse2 = new User();
        nurse2.setId(2L);
        nurse2.setFirstName("Nurse2");
        nurse2.setRole(roleNurse);
        nurses.add(nurse2);
        when(doctorRepository.findAllNurses()).thenReturn(nurses);
        List<User> result = doctorService.findAllNurses();
        assertEquals(2, result.size());
        assertEquals("nurse", result.get(0).getRole().getRoleName());
        assertEquals("nurse", result.get(1).getRole().getRoleName());
        assertEquals("Nurse1", result.get(0).getFirstName());
        assertEquals("Nurse2", result.get(1).getFirstName());
        // Verify that the userRepository method was called
        verify(doctorRepository, times(1)).findAllNurses();
    }

    @Test
    public void deleteByIdTest() {
        Long doctorId = 2L;
        doctorService.deleteById(doctorId);
        verify(doctorRepository, times(1)).deleteById(doctorId);
    }
}
