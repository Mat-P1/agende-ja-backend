package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.dto.request.BusinessRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.BusinessResponseDTO;
import br.edu.unifametro.aluno.agendeja.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("businesses")
@RequiredArgsConstructor
@Controller
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping("/register-business/{id}")
    ResponseEntity<BusinessResponseDTO> createBusiness(@PathVariable Long id, @RequestBody BusinessRequestDTO businessRequestDTO) {
        BusinessResponseDTO businessResponseDTO = businessService.create(id, businessRequestDTO);
        return new ResponseEntity<>(businessResponseDTO, HttpStatus.CREATED);
    }
}
