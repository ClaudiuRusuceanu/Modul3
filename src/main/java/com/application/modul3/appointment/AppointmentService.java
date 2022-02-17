package com.application.modul3.appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryRepository;
import com.application.modul3.user.User;
import com.application.modul3.user.UserService;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private UserService userService;

	public Set<Appointment> getAllAppointmentsForUser(Integer userId) {
		User user = userService.getUserById(userId);
		return appointmentRepository.findByUser(userId);
	}

	public List<Exemplary> findFreeExemplaries(LocalDate startDate, LocalDate endDate, Integer bookId) {
		return exemplaryRepository.getExemplariesForUserAndPeriod(startDate, endDate, bookId);
	}

	public void book(Appointment appointment, Integer exemplaryId, Integer userId) {
		Exemplary exemplary = exemplaryRepository.getById(exemplaryId);
		User user = userService.getUserById(userId);

		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);

		appointmentRepository.saveAndFlush(appointment);
	}

}