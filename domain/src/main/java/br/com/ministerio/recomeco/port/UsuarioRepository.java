package br.com.ministerio.recomeco.port;

import br.com.ministerio.recomeco.domain.dto.Usuario;

public interface UsuarioRepository {
    Usuario obterUsername(String username);
}
