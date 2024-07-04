package org.javier.usuarios.infrastructure.adapters.rest.mapper;

import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
    }
    )
    Usuario usuarioEntityToUsuario(UsuarioEntity usuarioEntity);

    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
    }
    )
    UsuarioEntity usuarioToUsuarioEntity(Usuario usuario);
    List<Usuario> usuarioEntitiesToUsuarios(List<UsuarioEntity> usuarioEntityList);
    List<UsuarioEntity> usuariosToUsuariosEntities(List<Usuario> usuarioList);


}
