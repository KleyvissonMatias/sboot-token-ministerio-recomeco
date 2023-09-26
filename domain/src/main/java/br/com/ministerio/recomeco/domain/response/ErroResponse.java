package br.com.ministerio.recomeco.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Builder
@Getter
@Setter
@Slf4j
public class ErroResponse implements Serializable {
    private Integer codigo;
    private String retorno;

    public ErroResponse(Integer codigo, String retorno) {
        this.codigo = codigo;
        this.retorno = retorno;
    }
}
