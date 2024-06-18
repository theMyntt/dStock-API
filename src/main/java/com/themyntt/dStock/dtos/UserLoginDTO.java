package com.themyntt.dStock.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Entrada de dados do usuário para login")
public class UserLoginDTO {
    @Schema(description = "Código de acesso", example = "1")
    private int id;

    @Schema(description = "Senha do usuário", example = "12345678")
    private String senha;
}
