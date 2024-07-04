package org.javier.usuarios.infrastructure.config;

import org.javier.usuarios.application.port.IUsuarioRepository;
import org.javier.usuarios.application.usecase.impl.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    UsuarioService usuarioService(IUsuarioRepository usuarioRepository){
        return new UsuarioService(usuarioRepository);
    }
}
