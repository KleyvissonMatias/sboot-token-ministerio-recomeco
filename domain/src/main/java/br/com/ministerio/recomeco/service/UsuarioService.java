package br.com.ministerio.recomeco.service;

import br.com.ministerio.recomeco.constant.Constans;
import br.com.ministerio.recomeco.domain.dto.Registra;
import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.enums.UserRole;
import br.com.ministerio.recomeco.port.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = userRepository.obterUsername(username);

        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException(Constans.SEM_REGISTRO);
        }
        return new User(
                usuario.orElse(new Usuario()).getUsername(),
                usuario.orElse(new Usuario()).getPassword(),
                usuario.orElse(new Usuario()).getAuthorities());
    }

    public void criar(Usuario usuario) {
        userRepository.criar(usuario);
    }
}
