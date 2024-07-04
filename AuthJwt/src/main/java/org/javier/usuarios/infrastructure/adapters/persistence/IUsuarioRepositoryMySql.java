package org.javier.usuarios.infrastructure.adapters.persistence;

import org.javier.usuarios.infrastructure.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioRepositoryMySql extends CrudRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByNombre(String nombre);


}
