package com.ivankoff.pschedule.repository;


import org.springframework.data.repository.CrudRepository;

import com.ivankoff.pschedule.entities.Doctor;


public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
