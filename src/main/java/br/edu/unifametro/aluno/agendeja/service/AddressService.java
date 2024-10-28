package br.edu.unifametro.aluno.agendeja.service;

import br.edu.unifametro.aluno.agendeja.domain.business.Address;
import br.edu.unifametro.aluno.agendeja.dto.request.AddressRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AddressResponseDTO;
import br.edu.unifametro.aluno.agendeja.mapper.AddressMapper;
import br.edu.unifametro.aluno.agendeja.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public AddressResponseDTO create(AddressRequestDTO addressRequestDTO) {
        Address address = AddressMapper.INSTANCE.requestDtoToAddress(addressRequestDTO);
        address.setExternalId(UUID.randomUUID());
        Address savedAddress = addressRepository.save(address);
        return AddressMapper.INSTANCE.addressToResponseDTO(savedAddress);
    }

    public AddressResponseDTO getById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return AddressMapper.INSTANCE.addressToResponseDTO(address);
    }

    public List<AddressResponseDTO> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(AddressMapper.INSTANCE::addressToResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AddressResponseDTO update(Long id, AddressRequestDTO addressRequestDTO) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        Address updatedAddress = AddressMapper.INSTANCE.requestDtoToAddress(addressRequestDTO);
        updatedAddress.setId(existingAddress.getId());
        updatedAddress.setExternalId(existingAddress.getExternalId());

        Address savedAddress = addressRepository.save(updatedAddress);
        return AddressMapper.INSTANCE.addressToResponseDTO(savedAddress);
    }

    @Transactional
    public void delete(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
