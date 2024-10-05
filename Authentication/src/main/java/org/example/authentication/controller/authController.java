package org.example.authentication.controller;

import org.example.authentication.common.authResponse;
import org.example.authentication.dto.authDTO;
import org.example.authentication.service.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")

public class authController {

    @Autowired
    private authService authService;

    @PostMapping("/register")
    public authResponse registerUser(@RequestBody authDTO registerUserDetails) {
       return authService.registerNewUser(registerUserDetails);
    }

}
