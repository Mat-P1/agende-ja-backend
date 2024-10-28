package br.edu.unifametro.aluno.agendeja.repository;

import br.edu.unifametro.aluno.agendeja.domain.booking.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByUserId(Long userId);

    List<Appointment> findByBusinessId(Long businessId);

    List<Appointment> findByStartBetween(LocalDateTime start, LocalDateTime end);
}
