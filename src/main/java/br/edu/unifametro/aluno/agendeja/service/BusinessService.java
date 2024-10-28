package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;

    public Business createBusiness(Business business) {
        business.setExternalId(UUID.randomUUID());
        return businessRepository.save(business);
    }
}
