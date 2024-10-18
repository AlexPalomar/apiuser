package com.domain.service;

import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.domain.interfaces.outgoing.auth.IAuthRepository;
import com.domain.interfaces.outgoing.auth.IJWT;
import com.domain.model.Role;
import com.domain.model.User;
import com.domain.service.auth.IAuthService;
import com.domain.service.util.ResponseAuth;
import com.infra.repository.auth.ImpAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final IAuthRepository iAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJWT iJWT;

    @Autowired
    public AuthService(IAuthRepository iAuthRepository, PasswordEncoder passwordEncoder, IJWT iJWT) {
        this.iAuthRepository = iAuthRepository;
        this.passwordEncoder = passwordEncoder;
        this.iJWT = iJWT;
    }

    @Override
    public ResponseEntity register(RegisterDTO registerDTO) {
        User user = new User(
                registerDTO.getName(),
                registerDTO.getFirstName(),
                registerDTO.getPhone()
        );
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setRole(Role.valueOf("USER"));
        ResponseEntity<User> response = iAuthRepository.register(user);
        String token = iJWT.getToken(response.getBody());
        ResponseAuth responseAuth = new ResponseAuth(token, response.getBody());
        return new ResponseEntity(responseAuth, response.getStatusCode());
    }

    @Override
    public ResponseEntity login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        ResponseEntity<Authentication> response = iAuthRepository.login(email, password);

        if (response.getBody() == null) {
            return response;
        }

        User user = (User) response.getBody().getPrincipal();
        System.out.println(user.getEmail() + "*");
        String token = iJWT.getToken(user);
        return new ResponseEntity(token, HttpStatus.OK);
    }
}
