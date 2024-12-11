package br.edu.unifametro.aluno.agendeja.mapper;

import br.edu.unifametro.aluno.agendeja.domain.booking.Appointment;
import br.edu.unifametro.aluno.agendeja.dto.request.AppointmentRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AppointmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "business.id", source = "businessId")
    Appointment requestDtoToAppointment(AppointmentRequestDTO appointmentRequestDTO);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "businessId", source = "business.id")
    @Mapping(target = "businessName", source = "business.businessName")
    @Mapping(target = "appointmentId", source = "appointment.id")
    AppointmentResponseDTO appointmentToResponseDTO(Appointment appointment);
}
