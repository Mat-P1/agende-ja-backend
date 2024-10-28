package br.edu.unifametro.aluno.agendeja.mapper;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.dto.request.UserRequestDTO;
import br.edu.unifametro.aluno.agendeja.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestDtoToUser(UserRequestDTO userRequestDTO);
    UserResponseDTO userToResponseDTO(User user);
}
