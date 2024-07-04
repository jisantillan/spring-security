package org.javier.usuarios.application.port;

import org.javier.usuarios.domain.model.Usuario;

import java.util.Optional;

public interface UserRepository {

    Usuario saveUsurio(Usuario usuario);
    Iterable<Usuario> getUsurios();
    Optional<Usuario> getUsuriosById(int usuarioId);
    Usuario updateUsurios(Usuario usuario);
    void deleteUsurios(int usuarioId);
    Optional<Usuario> findByNombre(String nombre);
}
