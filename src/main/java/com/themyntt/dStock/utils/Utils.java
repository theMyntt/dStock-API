package com.themyntt.dStock.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class StandardResponse {
    private String mensagem;
    private int status;
}

@Service
public class Utils {
    public ResponseEntity<StandardResponse> generateStandardResponse(String message, int status) {
        StandardResponse response = new StandardResponse();
        response.setMensagem(message);
        response.setStatus(status);
        return ResponseEntity.status(status).body(response);
    }

    public static String generateToken() {
        String id = UUID.randomUUID().toString();
        return id.replaceAll("-", "").substring(0, 15);
    }
}
