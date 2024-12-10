package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.dto.request.BusinessRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.BusinessResponseDTO;
import br.edu.unifametro.aluno.agendeja.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/registered/{id}")
    ResponseEntity<List<BusinessResponseDTO>> getBusiness(@PathVariable Long id) {
        List<BusinessResponseDTO> businessResponseDTO = businessService.getById(id);
        return new ResponseEntity<>(businessResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusinessResponseDTO>> getAll() {
        List<BusinessResponseDTO> businesses = businessService.getAll();
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<BusinessResponseDTO> updateUser(@PathVariable Long id, @RequestBody BusinessRequestDTO businessRequestDTO) {
        BusinessResponseDTO businessResponseDTO = businessService.update(id, businessRequestDTO);
        if (businessResponseDTO != null) {
            return new ResponseEntity<>(businessResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
