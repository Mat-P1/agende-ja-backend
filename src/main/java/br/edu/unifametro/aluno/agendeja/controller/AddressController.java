package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.dto.request.AddressRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AddressResponseDTO;
import br.edu.unifametro.aluno.agendeja.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponseDTO> create(@RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO addressResponseDTO = addressService.create(addressRequestDTO);
        return new ResponseEntity<>(addressResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> getById(@PathVariable Long id) {
        AddressResponseDTO addressResponseDTO = addressService.getById(id);
        return ResponseEntity.ok(addressResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAll() {
        List<AddressResponseDTO> addresses = addressService.getAll();
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponseDTO> update(@PathVariable Long id, @RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO addressResponseDTO = addressService.update(id, addressRequestDTO);
        return ResponseEntity.ok(addressResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
