package com.ivankoff.pschedule;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ivankoff.pschedule.entities.Appointment;
import com.ivankoff.pschedule.entities.Doctor;
import com.ivankoff.pschedule.entities.Insurance;
import com.ivankoff.pschedule.entities.Patient;
import com.ivankoff.pschedule.repository.AppointmentRepository;
import com.ivankoff.pschedule.repository.DoctorRepository;
import com.ivankoff.pschedule.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PScheduleApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateDoctor() {
        Doctor doctor = new Doctor();
                              doctor.setFirstName("Michael");
                              doctor.setLastName("Brown");
                              doctor.setSpeciality("Therapy");
        doctorRepository.save(doctor);

    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Douch");
        patient.setLastName("Boolean");
        patient.setPhone("123-221-2212");

        Insurance insurance=new Insurance();
        insurance.setProviderName("Blue Cross & Blue Shields");
        insurance.setCopay(35D);
        patient.setInsurance(insurance);

        Doctor doctor=doctorRepository.findById(3L).get();
        List<Doctor> asList = Arrays.asList(doctor);
        patient.setDoctors( asList );

        patientRepository.save(patient);

    }

    @Test
    public void testCreateAppointment() {
        Timestamp appointementTime = new Timestamp( new java.util.Date().getTime() );

        Patient patient = patientRepository.findById(1L).get();
        Doctor doctor = doctorRepository.findById(3L).get();

        Appointment appointment = new Appointment();
                    appointment.setAppointmentTime(appointementTime);
                    appointment.setReason("I have a problem");
                    appointment.setPatient(patient);
                    appointment.setDoctor( doctor );
                    appointment.setStarted(true);
        appointmentRepository.save(appointment);
    }

}





