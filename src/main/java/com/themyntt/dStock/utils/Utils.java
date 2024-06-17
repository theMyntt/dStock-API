package com.themyntt.dStock.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class StandardResponse {
    private String message;
    private int status;
}

public class Utils {
    public StandardResponse generateStandardResponse(String message, int status) {
        StandardResponse response = new StandardResponse();
        response.setMessage(message);
        response.setStatus(status);
        return response;
    }
}
