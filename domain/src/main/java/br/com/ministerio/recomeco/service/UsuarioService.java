package br.com.ministerio.recomeco.service;

import br.com.ministerio.recomeco.constant.Constans;
import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.exception.UsernameBadRequestException;
import br.com.ministerio.recomeco.port.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuario = userRepository.obterUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(Constans.SEM_REGISTRO);
        }
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getAuthorities());
    }

    public boolean existeUsername(String username) {
        UserDetails usuario = userRepository.obterUsername(username);

        if (usuario != null) {
            throw new UsernameBadRequestException(HttpStatus.BAD_REQUEST, Constans.USUARIO_CADASTRADO);
        }
        return true;
    }

    public void criar(Usuario usuario) {
        userRepository.criar(usuario);
    }
}
