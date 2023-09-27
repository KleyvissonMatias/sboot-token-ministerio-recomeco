package br.com.ministerio.recomeco.port;

import br.com.ministerio.recomeco.domain.dto.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository {
    UserDetails obterUsername(String username);
    void criar(Usuario usuario);
}
