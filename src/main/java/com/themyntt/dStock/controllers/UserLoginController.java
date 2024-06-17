package com.themyntt.dStock.controllers;

import com.themyntt.dStock.contracts.IControllerContract;
import com.themyntt.dStock.dtos.UserLoginDTO;
import com.themyntt.dStock.usecases.UserLoginUsecase;
import com.themyntt.dStock.utils.Utils;
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
    public ResponseEntity<?> perform(@RequestBody() UserLoginDTO dto) {
        try {
            return useCase.run(dto);
        } catch (Exception e) {
            return utils.generateStandardResponse("Erro interno de servidor", 500);
        }
    }
}
