package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.dto.request.LoginRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.request.UserRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.LoginResponseDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.UserResponseDTO;
import br.edu.unifametro.aluno.agendeja.service.LoginService;
import br.edu.unifametro.aluno.agendeja.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/sign_up")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.create(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/sign_in")
    public ResponseEntity<LoginResponseDTO> signIn(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<LoginResponseDTO> loginResponseDTO = loginService.findByEmail(loginRequestDTO);
        return loginResponseDTO.map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.update(id, userRequestDTO);
        if (userResponseDTO != null) {
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}