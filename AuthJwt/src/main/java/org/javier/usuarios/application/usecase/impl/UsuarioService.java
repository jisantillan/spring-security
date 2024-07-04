package org.javier.usuarios.application.usecase.impl;

import org.javier.usuarios.application.port.IUsuarioRepository;
import org.javier.usuarios.application.usecase.IUsuarioService;
import org.javier.usuarios.domain.model.Usuario;
import org.javier.usuarios.infrastructure.entity.UsuarioEntity;
import org.javier.usuarios.infrastructure.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.saveUsurio(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.getUsurios();
    }

    @Override
    public Optional<Usuario> porId(Long usuarioId) throws ResourceNotFoundException {
        return usuarioRepository.getUsuriosById(usuarioId);
    }

    @Override
    public Usuario modificar(Usuario usuario, Long usuarioId) {
        return usuarioRepository.modificarUsuario(usuario, usuarioId);
    }

    @Override
    public void eliminar(Long usuarioId) {
        usuarioRepository.deleteUsurios(usuarioId);
    }
}
