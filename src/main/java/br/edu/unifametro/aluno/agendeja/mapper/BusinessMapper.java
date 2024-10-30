package br.edu.unifametro.aluno.agendeja.mapper;

import br.edu.unifametro.aluno.agendeja.domain.business.Business;
import br.edu.unifametro.aluno.agendeja.dto.request.BusinessRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.BusinessResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusinessMapper {

    BusinessMapper INSTANCE = Mappers.getMapper(BusinessMapper.class);

    Business businessRequestDtoToBusiness(BusinessRequestDTO businessRequestDTO);

    @Mapping(target = "businessId", source = "business.id")
    @Mapping(target = "userExternalId", source = "user.externalId")
    @Mapping(target = "userGovernmentId", source = "user.governmentId")
    @Mapping(target = "userFirstName", source = "user.firstName")
    @Mapping(target = "userLastName", source = "user.lastName")
    BusinessResponseDTO businessToBusinessResponseDTO(Business business);
}
