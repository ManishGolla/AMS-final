package com.ams.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ams.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	@Query(value="SELECT * FROM appointment a WHERE a.customer_id=:custId",nativeQuery=true)
	List<Appointment> getCustomerAppointments(@Param("custId") String custId);
	
	@Query(value="SELECT * FROM appointment a WHERE a.agent_id=:agntId",nativeQuery=true)
	List<Appointment> findByAgentId(@Param("agntId") String agntId);
}
