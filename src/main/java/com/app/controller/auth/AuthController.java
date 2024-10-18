package com.app.controller.auth;

import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.domain.service.auth.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody RegisterDTO registerDTO) {
        ResponseEntity response = authService.register(registerDTO);
        return response;

    }

    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginDTO loginDTO) {
        ResponseEntity response = authService.login(loginDTO);
        return response;
    }

}
