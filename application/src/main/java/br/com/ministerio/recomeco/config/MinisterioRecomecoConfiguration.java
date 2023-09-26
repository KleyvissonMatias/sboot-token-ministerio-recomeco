package br.com.ministerio.recomeco.config;

import br.com.ministerio.recomeco.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinisterioRecomecoConfiguration {
    @Bean
    public UsuarioService vidaService() {
        return new UsuarioService();
    }
}