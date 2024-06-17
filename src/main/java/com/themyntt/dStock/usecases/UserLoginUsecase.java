package com.themyntt.dStock.usecases;

import com.themyntt.dStock.contracts.IUseCaseContract;
import com.themyntt.dStock.dtos.UserLoginDTO;
import com.themyntt.dStock.models.UserModel;
import com.themyntt.dStock.repositories.UserRepository;
import com.themyntt.dStock.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserLoginRES {
    private List<String> tokens;
    private String nome;
}

@Service
public class UserLoginUsecase implements IUseCaseContract<UserLoginDTO, ResponseEntity<?>> {
    @Autowired
    private UserRepository repo;

    @Autowired
    private Utils utils;

    @Override
    public ResponseEntity<?> run(UserLoginDTO dto) {
        if (dto.senha.isEmpty() || dto.id == 0) {
            return utils.generateStandardResponse("Não podem existir campos nulos", 400);
        }

        UserModel brute = repo.findByAccess(dto.id, dto.senha);
        if (brute.getNome() == null || brute.getPassword() == null) {
            return utils.generateStandardResponse("Nenhum usuário encontrado", 404);
        }

        UserLoginRES response = new UserLoginRES();
        List<String> tokens = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            tokens.add(Utils.generateToken());
        }

        response.setTokens(tokens);
        response.setNome(brute.getNome());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
