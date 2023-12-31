package br.com.ministerio.recomeco.presentation;

import br.com.ministerio.recomeco.config.jwt.TokenService;
import br.com.ministerio.recomeco.constant.Constans;
import br.com.ministerio.recomeco.domain.dto.Registra;
import br.com.ministerio.recomeco.domain.dto.Usuario;
import br.com.ministerio.recomeco.domain.request.AuthRequest;
import br.com.ministerio.recomeco.domain.response.ErroResponse;
import br.com.ministerio.recomeco.domain.response.LoginResponse;
import br.com.ministerio.recomeco.exception.UsernameBadRequestException;
import br.com.ministerio.recomeco.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/ministerio-recomeco/token")
@Slf4j
public class UsuarioController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService service;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((UserDetails) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException e) {
            ErroResponse erroResponse = new ErroResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ErroResponse erroResponse = new ErroResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constans.ERRO_INTERNO);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroResponse);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody @Valid Registra data) {
        try {
            boolean existeUsername = service.existeUsername(data.username());
            if (existeUsername) {
                String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
                Usuario novoUsuario = new Usuario(data.username(), encryptedPassword, data.email(), data.role());
                this.service.criar(novoUsuario);
            }
            return ResponseEntity.ok().build();
        } catch (UsernameBadRequestException e) {
            ErroResponse erroResponse = new ErroResponse(e.getStatus().value(), e.getMessage());
            return ResponseEntity.status(e.getStatus().value()).body(erroResponse);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ErroResponse erroResponse = new ErroResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constans.ERRO_INTERNO);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroResponse);
        }
    }
}
