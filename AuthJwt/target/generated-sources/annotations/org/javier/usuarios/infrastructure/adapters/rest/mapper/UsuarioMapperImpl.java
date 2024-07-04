package org.javier.usuarios.infrastructure.adapters.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-06T14:35:52-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario usuarioEntityToUsuario(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nombre( usuarioEntity.getNombre() );
        usuario.email( usuarioEntity.getEmail() );
        usuario.password( usuarioEntity.getPassword() );

        return usuario.build();
    }

    @Override
    public UsuarioEntity usuarioToUsuarioEntity(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioEntity.UsuarioEntityBuilder usuarioEntity = UsuarioEntity.builder();

        usuarioEntity.nombre( usuario.getNombre() );
        usuarioEntity.email( usuario.getEmail() );
        usuarioEntity.password( usuario.getPassword() );

        return usuarioEntity.build();
    }

    @Override
    public List<Usuario> usuarioEntitiesToUsuarios(List<UsuarioEntity> usuarioEntityList) {
        if ( usuarioEntityList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( usuarioEntityList.size() );
        for ( UsuarioEntity usuarioEntity : usuarioEntityList ) {
            list.add( usuarioEntityToUsuario( usuarioEntity ) );
        }

        return list;
    }

    @Override
    public List<UsuarioEntity> usuariosToUsuariosEntities(List<Usuario> usuarioList) {
        if ( usuarioList == null ) {
            return null;
        }

        List<UsuarioEntity> list = new ArrayList<UsuarioEntity>( usuarioList.size() );
        for ( Usuario usuario : usuarioList ) {
            list.add( usuarioToUsuarioEntity( usuario ) );
        }

        return list;
    }
}
