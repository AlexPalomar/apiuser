package com.app.controller.auth;

import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.domain.service.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody RegisterDTO registerDTO) {
        ResponseEntity response = authService.register(registerDTO);
        return response;

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        ResponseEntity response = authService.login(loginDTO);
        return response;
    }

}
