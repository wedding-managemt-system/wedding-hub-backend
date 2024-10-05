package org.example.authentication.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.authentication.dto.authDTO;

@Getter
public class loginSuccessResponse implements authResponse{
    @JsonUnwrapped
    private authDTO authDTO;
    
    public loginSuccessResponse(authDTO authDTO){
        this.authDTO = authDTO;
    }
}
