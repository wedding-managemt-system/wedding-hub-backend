package org.example.authentication.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.authentication.dto.authDTO;
import org.example.authentication.model.authModel;

@Getter
public class authSuccessResponse implements authResponse{
   @JsonUnwrapped
    private authModel authModel;

   public authSuccessResponse(authModel authModel){
        this.authModel = authModel;
   }
}


