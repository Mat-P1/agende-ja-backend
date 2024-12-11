package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.dto.request.AppointmentRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AppointmentResponseDTO;
import br.edu.unifametro.aluno.agendeja.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
@RequiredArgsConstructor
@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    /* Cria um novo agendamento */

    @PostMapping("/schedule")
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.create(appointmentRequestDTO);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.CREATED);
    }

    /* Mostra todos os agendamentos associados ao id do user */

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AppointmentResponseDTO>> getByUserId(@PathVariable Long id) {
        List<AppointmentResponseDTO> appointmentResponseDTO = appointmentService.getByUserId(id);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.OK);
    }

    /* Mostra todos os agendamentos associados ao id do business */

    @GetMapping("/business/{id}")
    public ResponseEntity<List<AppointmentResponseDTO>> getByBusinessId(@PathVariable Long id) {
        List<AppointmentResponseDTO> appointments = appointmentService.getByBusinessId(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    /* Editar um agendamento */

    @PutMapping("edit/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.update(id, appointmentRequestDTO);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.OK);
    }

    /* Deletar um agendamento */

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
