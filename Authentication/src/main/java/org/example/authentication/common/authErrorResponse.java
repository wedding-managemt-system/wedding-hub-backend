package org.example.authentication.common;

import lombok.Getter;

@Getter
public class authErrorResponse implements authResponse {
    private String errorMessage;

    public authErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
