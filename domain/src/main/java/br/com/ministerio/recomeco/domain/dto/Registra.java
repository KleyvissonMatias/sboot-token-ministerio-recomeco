package br.com.ministerio.recomeco.domain.dto;

import br.com.ministerio.recomeco.enums.UserRole;

public record Registra(String usernmame, String password, String email, UserRole role) {
}
