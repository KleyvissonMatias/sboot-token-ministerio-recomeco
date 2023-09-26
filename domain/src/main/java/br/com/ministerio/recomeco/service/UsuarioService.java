package br.com.ministerio.recomeco.service;

import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.port.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.obterUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), new ArrayList<>());
    }
}
