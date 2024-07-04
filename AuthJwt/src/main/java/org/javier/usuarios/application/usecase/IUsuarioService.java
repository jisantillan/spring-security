package org.javier.usuarios.application.usecase;

import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario guardar(Usuario usuario);
    List<Usuario> listar();
    Optional<Usuario> porId(Long usuarioId) throws ResourceNotFoundException;
    Usuario modificar(Usuario usuario, Long usuarioId);
    void eliminar(Long usuarioId);
}
