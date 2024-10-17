
package com.domain.service.auth;

import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;


public interface IAuthService {
    
    public ResponseEntity registro(RegisterDTO registerDTO);
    
    public ResponseEntity login(LoginDTO loginDTO);
}
