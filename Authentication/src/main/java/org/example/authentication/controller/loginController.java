package org.example.authentication.controller;


import org.example.authentication.common.authResponse;
import org.example.authentication.dto.authDTO;
import org.example.authentication.service.loginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class loginController {
    @Autowired
    private loginServices Loginservice;

    @PostMapping("/login")
    public authResponse loginUser(@RequestBody authDTO authdto ){
        return Loginservice.loginWithCredential(authdto);
    }
}