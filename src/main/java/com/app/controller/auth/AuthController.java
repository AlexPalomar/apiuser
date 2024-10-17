
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

    private final IAuthService iAuthService;
    
    @Autowired
    public AuthController(IAuthService iAuthService){
        this.iAuthService = iAuthService;
    }
    
    
    @PostMapping("/registro")
    public ResponseEntity createUser(@RequestBody RegisterDTO registerDTO){
        ResponseEntity response = iAuthService.registro(registerDTO);
        return response;
         
    }
    
    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody LoginDTO loginDTO){
         
        ResponseEntity response = iAuthService.login(loginDTO);
        return response;
    }
    
}
