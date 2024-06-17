package com.themyntt.dStock.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class StandardResponse {
    private String message;
    private int status;
}

public class Utils {
    public ResponseEntity<StandardResponse> generateStandardResponse(String message, int status) {
        StandardResponse response = new StandardResponse();
        response.setMessage(message);
        response.setStatus(status);
        return ResponseEntity.status(status).body(response);
    }

    public static String generateToken() {
        String id = UUID.randomUUID().toString();
        return id.replaceAll("-", "").substring(0, 15);
    }
}
