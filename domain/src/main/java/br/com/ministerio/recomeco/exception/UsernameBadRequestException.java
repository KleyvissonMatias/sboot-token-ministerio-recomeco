package br.com.ministerio.recomeco.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Slf4j
public class UsernameBadRequestException extends RuntimeException {
    private HttpStatus status;
    private String mensagemErro;
    private Object data;

    public UsernameBadRequestException(HttpStatus status, String mensagemErro) {
        super(mensagemErro);
        this.status = status;
        this.mensagemErro = mensagemErro;
        logError();
    }
    private void logError() {
        log.error("Erro: Status={}, Mensagem={}", status, mensagemErro);
    }
}
