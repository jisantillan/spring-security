package org.javier.usuarios.application.port;

import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.exceptions.ResourceNotFoundException;

import java.util.Optional;

public interface IUsuarioRepository {

    Usuario saveUsurio(Usuario usuario);
    Iterable<Usuario> getUsurios();
    Optional<Usuario> getUsuriosById(Long usuarioId) throws ResourceNotFoundException;
    Optional<Usuario> getUsuarioByNombre(String nombre) throws ResourceNotFoundException;
    Usuario updateUsurios(Usuario usuario);
    void deleteUsurios(Long usuarioId);
    Usuario modificarUsuario(Usuario usuario, Long usuarioId);

}
