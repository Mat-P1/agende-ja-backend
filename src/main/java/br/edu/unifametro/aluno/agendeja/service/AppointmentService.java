package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.booking.Appointment;
import br.edu.unifametro.aluno.agendeja.dto.request.AppointmentRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AppointmentResponseDTO;
import br.edu.unifametro.aluno.agendeja.mapper.AppointmentMapper;
import br.edu.unifametro.aluno.agendeja.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Transactional
    public AppointmentResponseDTO create(AppointmentRequestDTO appointmentRequestDTO) {
        Appointment appointment = AppointmentMapper.INSTANCE.requestDtoToAppointment(appointmentRequestDTO);
        appointment.setExternalId(UUID.randomUUID());
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.INSTANCE.appointmentToResponseDTO(savedAppointment);
    }

    public List<AppointmentResponseDTO> getByUserId(Long id) {
        List<Appointment> appointments = appointmentRepository.findByUserId(id);
        return appointments.stream()
                .map(AppointmentMapper.INSTANCE::appointmentToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<AppointmentResponseDTO> getByBusinessId(Long id) {
        List<Appointment> appointments = appointmentRepository.findByBusinessId(id);
        return appointments.stream()
                .map(AppointmentMapper.INSTANCE::appointmentToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AppointmentResponseDTO update(Long id, AppointmentRequestDTO appointmentRequestDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Appointment updatedAppointment = AppointmentMapper.INSTANCE.requestDtoToAppointment(appointmentRequestDTO);
        updatedAppointment.setId(existingAppointment.getId());
        updatedAppointment.setExternalId(existingAppointment.getExternalId());

        Appointment savedAppointment = appointmentRepository.save(updatedAppointment);
        return AppointmentMapper.INSTANCE.appointmentToResponseDTO(savedAppointment);
    }

    @Transactional
    public void delete(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }
}
