package br.edu.unifametro.aluno.agendeja.controller;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("businesses")
@RequiredArgsConstructor
@Controller
public class BusinessController {

   private final BusinessService businessService;

    @PostMapping("/register-business")
    ResponseEntity<Business> createBusiness(@RequestBody Business business) {
        businessService.createBusiness(business);
        return new ResponseEntity<>(business, HttpStatus.CREATED);
    }
}
