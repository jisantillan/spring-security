package org.javier.usuarios.infrastructure.adapters.persistence;

import org.javier.usuarios.application.port.IUsuarioRepository;
import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.adapters.rest.mapper.UsuarioMapper;
import org.javier.usuarios.infrastructure.entity.UsuarioEntity;
import org.javier.usuarios.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryMySql implements IUsuarioRepository {

    private final IUsuarioRepositoryMySql usuarioRepositoryMySql;

    @Autowired
    private UsuarioMapper mapper;

    public UsuarioRepositoryMySql(IUsuarioRepositoryMySql usuarioRepositoryMySql){
        this.usuarioRepositoryMySql = usuarioRepositoryMySql;
    }
    @Override
    @Transactional
    public Usuario saveUsurio(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.usuarioToUsuarioEntity(usuario);
        return mapper.usuarioEntityToUsuario(usuarioRepositoryMySql.save(usuarioEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> getUsurios() {
        return mapper.usuarioEntitiesToUsuarios((List<UsuarioEntity>) usuarioRepositoryMySql.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> getUsuriosById(Long usuarioId) throws ResourceNotFoundException {
        UsuarioEntity usuarioEntity = this.usuarioRepositoryMySql.findById(usuarioId).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado") // cambiar a ResourceNotFoundException
        );
        return Optional.of(this.mapper.usuarioEntityToUsuario(usuarioEntity));
    }

    @Override
    public Optional<Usuario> getUsuarioByNombre(String nombre) throws ResourceNotFoundException {
        UsuarioEntity usuarioEntity = this.usuarioRepositoryMySql.findByNombre(nombre).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso no encontrado")
        );
        return Optional.of(this.mapper.usuarioEntityToUsuario(usuarioEntity));
    }

    @Override
    @Transactional
    public Usuario updateUsurios(Usuario usuario) {
        return null;
    }

    @Override
    @Transactional
    public void deleteUsurios(Long usuarioId) {
        this.usuarioRepositoryMySql.deleteById(usuarioId);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario, Long usuarioId) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepositoryMySql.findById(usuarioId);
        if (usuarioOptional.isPresent()){
            UsuarioEntity usuarioEntity = usuarioOptional.get();
            usuarioEntity.setNombre(usuario.getNombre());
            usuarioEntity.setPassword(usuario.getPassword());
            usuarioEntity.setEmail(usuario.getEmail());
            return mapper.usuarioEntityToUsuario(usuarioRepositoryMySql.save(usuarioEntity));
        }
        return saveUsurio(usuario);
    }
}
