
package com.infra.repository.auth;

import com.app.dto.LoginDTO;
import com.domain.interfaces.outgoing.auth.IAuthORM;
import com.domain.interfaces.outgoing.auth.IAuthRepository;
import com.domain.model.User;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

@Repository
public class ImpAuth implements IAuthRepository{
    
    private final IAuthORM iAuthORM;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public ImpAuth(IAuthORM iAuthORM, AuthenticationManager authenticationManager) {
        this.iAuthORM = iAuthORM;
        this.authenticationManager = authenticationManager;
    }
    

    @Override
    public ResponseEntity register(User user) {
        try {
            User userResponse = iAuthORM.save(user);
            return new ResponseEntity(
                    userResponse, 
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(
                    "client not found"+ e.getMessage(),
                    HttpStatus.OK);
        }
        
        
    }

    @Override
    public ResponseEntity login(String email, String password) {
        try {
            Authentication authenticationToken = this.authenticationManager(email, password);
            return new ResponseEntity(authenticationToken, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }
        
    }

    public Authentication authenticationManager(String email, String password){
        
        return authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password)
        );
    }
    
    
}
