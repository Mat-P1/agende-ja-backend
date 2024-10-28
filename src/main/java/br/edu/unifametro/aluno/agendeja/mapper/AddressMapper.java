package br.edu.unifametro.aluno.agendeja.mapper;

import br.edu.unifametro.aluno.agendeja.domain.business.Address;
import br.edu.unifametro.aluno.agendeja.dto.request.AddressRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.AddressResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "business.id", source = "businessId")
    Address requestDtoToAddress(AddressRequestDTO addressRequestDTO);

    @Mapping(target = "businessId", source = "business.id")
    AddressResponseDTO addressToResponseDTO(Address address);
}
