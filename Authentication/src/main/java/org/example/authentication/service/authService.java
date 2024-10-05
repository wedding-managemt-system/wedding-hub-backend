package org.example.authentication.service;


import jakarta.transaction.Transactional;
import org.example.authentication.common.authErrorResponse;
import org.example.authentication.common.authResponse;
import org.example.authentication.common.authSuccessResponse;
import org.example.authentication.common.loginSuccessResponse;
import org.example.authentication.dto.authDTO;
import org.example.authentication.repo.authRepo;
import org.example.authentication.model.authModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class authService {
    @Autowired
    private authRepo authRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

// Register new user
public authResponse registerNewUser(authDTO authDTO) {

    try {
        // Extract user details from authDTO
        String username = authDTO.getUsername();
        String password = authDTO.getPassword();
        String email = authDTO.getEmail();

        // Hash the password using BCryptPasswordEncoder
        String hashPassword = bCryptPasswordEncoder.encode(password);

        // Create and map the authModel
        authModel authModel = modelMapper.map(authDTO, authModel.class); // Map DTO to Model
        authModel.setPassword(hashPassword); // Override with hashed password

        // Save the user to the repository
        authRepo.save(authModel);

        // Return success response
        return new authSuccessResponse(authModel);

    } catch (Exception e) {
        // Return error response in case of failure
        return new authErrorResponse("Registration encountered an issue. Please try again!");
    }
}
}


