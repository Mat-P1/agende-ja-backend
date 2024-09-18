package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.request.login.LoginRequest;
import br.edu.unifametro.aluno.agendeja.request.user.UserPostRequestBody;
import br.edu.unifametro.aluno.agendeja.service.LoginService;
import br.edu.unifametro.aluno.agendeja.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UserController handles user-related operations such as sign-up and registration.
 * This controller provides REST API endpoints for user creation.
 * It interacts with the UserService to perform business logic.
 * <p>
 * Annotations:
 * - @RestController: Marks this class as a REST controller, responsible for handling HTTP requests.
 * - @RequestMapping("users"): Maps HTTP requests to /users URI for user-related operations.
 * - @RequiredArgsConstructor: Automatically generates a constructor for required fields, promoting dependency injection.
 * <p>
 * Dependencies:
 * - UserService: Service class to handle user creation and other user-related business logic.
 */

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    /**
     * Handles HTTP POST requests to /sign-up for user registration.
     * The method receives a {@link UserPostRequestBody} as a JSON payload and
     * returns the created {@link User} with HTTP status 201 (CREATED).
     *
     * @param user The user registration details encapsulated in a {@link UserPostRequestBody}.
     * @return A {@link ResponseEntity} containing the created {@link User} and an HTTP status of CREATED.
     */

    @PostMapping("/sign_up")
    public ResponseEntity<User> signUp(@RequestBody UserPostRequestBody user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign_in")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(loginService.findByEmail(loginRequest), HttpStatus.OK);
    }
}