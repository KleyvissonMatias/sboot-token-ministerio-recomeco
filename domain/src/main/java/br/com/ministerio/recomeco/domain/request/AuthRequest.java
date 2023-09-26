package br.com.ministerio.recomeco.domain.request;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthRequest implements Serializable {
    private String username;
    private String password;
}
