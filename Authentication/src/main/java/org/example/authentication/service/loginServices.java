package org.example.authentication.service;


import jakarta.transaction.Transactional;
import org.example.authentication.common.authErrorResponse;
import org.example.authentication.common.authResponse;
import org.example.authentication.common.authSuccessResponse;
import org.example.authentication.common.loginSuccessResponse;
import org.example.authentication.dto.authDTO;
import org.example.authentication.repo.authRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.authentication.model.authModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@Transactional

public class loginServices {
    @Autowired
    private authRepo authRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public authResponse loginWithCredential(authDTO authDTO){
        try {
            String email = authDTO.getEmail();
            String password = authDTO.getPassword();

            authModel user = authRepo.findByEmail(email);
            if (user == null){
                return new authErrorResponse("User not found");
            }

            boolean passwordMatch = bCryptPasswordEncoder.matches(password , user.getPassword());

            if(passwordMatch){
                return new authSuccessResponse(user);
            }

            return new authErrorResponse("Wrong password");

        }catch (Exception e){
            return new authErrorResponse("Have an error while login user");
        }

    }
}
