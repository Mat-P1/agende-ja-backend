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

    @PostMapping("/schedule")
    public ResponseEntity<AppointmentResponseDTO> create(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.create(appointmentRequestDTO);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> getById(@PathVariable Long id) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.getByExternalId(id);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAll() {
        List<AppointmentResponseDTO> appointments = appointmentService.getAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable Long id, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.update(id, appointmentRequestDTO);
        return new ResponseEntity<>(appointmentResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
