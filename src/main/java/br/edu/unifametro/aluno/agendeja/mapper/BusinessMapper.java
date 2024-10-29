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

    @Mapping(target = "userExternalId", source = "user.externalId")
    BusinessResponseDTO businessToBusinessResponseDTO(Business business);
}
