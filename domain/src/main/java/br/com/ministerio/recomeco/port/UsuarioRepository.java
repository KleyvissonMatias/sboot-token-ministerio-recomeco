package br.com.ministerio.recomeco.port;

import br.com.ministerio.recomeco.domain.dto.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> obterUsername(String username);
    void criar(Usuario usuario);
}
