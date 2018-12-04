package com.ivankoff.pschedule.repository;


import org.springframework.data.repository.CrudRepository;

import com.ivankoff.pschedule.entities.Patient;


public interface PatientRepository extends CrudRepository<Patient, Long> {
}
