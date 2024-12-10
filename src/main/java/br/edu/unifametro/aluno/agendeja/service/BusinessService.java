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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Transactional
    public List<BusinessResponseDTO> getById(Long id) {
        List<Business> businesses = businessRepository.findByUserId(id);
        if (businesses.isEmpty()) {
            throw new UsernameNotFoundException("Business not found");
        }
        return businesses.stream()
                .map(BusinessMapper.INSTANCE::businessToBusinessResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<BusinessResponseDTO> getAll() {
        List<Business> businesses = businessRepository.findAll();
        return businesses.stream()
                .map(BusinessMapper.INSTANCE::businessToBusinessResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BusinessResponseDTO update(Long id, BusinessRequestDTO businessRequestDTO) {
        Optional<Business> existingBusinessOpt = businessRepository.findById(id);
        if (existingBusinessOpt.isPresent()) {
            Business existingBusiness = existingBusinessOpt.get();

            existingBusiness.setBusinessName(businessRequestDTO.businessName());
            existingBusiness.setBusinessDescription(businessRequestDTO.businessDescription());
            existingBusiness.setBusinessPhoneNumber(businessRequestDTO.businessPhoneNumber());

            Business savedBusiness = businessRepository.save(existingBusiness);
            return BusinessMapper.INSTANCE.businessToBusinessResponseDTO(savedBusiness);
        }
        return null;
    }
}
