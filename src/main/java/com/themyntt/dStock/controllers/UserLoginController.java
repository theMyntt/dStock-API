package com.themyntt.dStock.controllers;

import com.themyntt.dStock.contracts.IControllerContract;
import com.themyntt.dStock.dtos.UserLoginDTO;
import com.themyntt.dStock.models.UserModel;
import com.themyntt.dStock.usecases.UserLoginUsecase;
import com.themyntt.dStock.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user/")
@RestController
public class UserLoginController implements IControllerContract<UserLoginDTO, ResponseEntity<?>> {
    @Autowired
    private UserLoginUsecase useCase;

    @Autowired
    private Utils utils;

    @Override
    @PostMapping("/login/")
    @Operation(
            summary = "Obtém um usuário pelo seu código de acesso e senha",
            description = "Retorna 3 tokens e o nome do usuário",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuário existente", content = @Content(schema = @Schema(
                            implementation = UserLoginDTO.class
                    ), examples = @ExampleObject(
                            value = "{ \"tokens\": [ \"a\", \"b\", \"c\"  ], \"nome\": \"John Doe\" }"
                    ))),
                    @ApiResponse(responseCode = "400", description = "Informações incorretas", content = @Content(schema = @Schema(
                            implementation = UserLoginDTO.class
                    ), examples = @ExampleObject(
                            value = "{\"mensagem\":\"Não podem existir campos nulos\",\"status\":400}"
                    ))),
                    @ApiResponse(responseCode = "404", description = "Usuário não encontrado", content = @Content(schema = @Schema(
                            implementation = UserLoginDTO.class
                    ), examples = @ExampleObject(
                            value = "{\"mensagem\":\"Usuário não encontrado\",\"status\":404}"
                    ))),
                    @ApiResponse(responseCode = "500", description = "Erro interno de servidor", content = @Content(schema = @Schema(
                            implementation = UserLoginDTO.class
                    ), examples = @ExampleObject(
                            value = "{\"mensagem\":\"Erro interno de servidor\",\"status\":500}"
                    )))
            },
            tags = "Gerenciamento de usuário"
    )
    public ResponseEntity<?> perform(@RequestBody() UserLoginDTO dto) {
        try {
            return useCase.run(dto);
        } catch (Exception e) {
            return utils.generateStandardResponse("Erro interno de servidor", 500);
        }
    }
}
