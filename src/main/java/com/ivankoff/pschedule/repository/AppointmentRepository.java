package com.ivankoff.pschedule.repository;


import org.springframework.data.repository.CrudRepository;

import com.ivankoff.pschedule.entities.Appointment;



public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
