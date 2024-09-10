package br.edu.unifametro.aluno.agendeja.mapper;

import br.edu.unifametro.aluno.agendeja.domain.user.User;
import br.edu.unifametro.aluno.agendeja.request.user.UserPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        User postRequestBodyToUser(UserPostRequestBody userPostRequestBody);
}
