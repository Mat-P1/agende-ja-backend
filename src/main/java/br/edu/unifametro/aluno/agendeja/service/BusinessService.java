package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.dto.request.BusinessRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.BusinessResponseDTO;
import br.edu.unifametro.aluno.agendeja.mapper.BusinessMapper;
import br.edu.unifametro.aluno.agendeja.repository.BusinessRepository;
import br.edu.unifametro.aluno.agendeja.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;

    @Transactional
    public BusinessResponseDTO create(Long id, BusinessRequestDTO businessRequestDTO) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {

            Business business = BusinessMapper.INSTANCE.businessRequestDtoToBusiness(businessRequestDTO);
            business.setUser(user.get());
            business.setExternalId(UUID.randomUUID());

            return BusinessMapper.INSTANCE.businessToBusinessResponseDTO(businessRepository.save(business));
        } else {
           throw new UsernameNotFoundException("User not found");
        }
    }
}
