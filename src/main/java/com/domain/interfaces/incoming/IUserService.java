package com.domain.interfaces.incoming;

import com.app.dto.UserDTO;
import org.springframework.http.ResponseEntity;


public interface IUserService {
    
    public ResponseEntity createUser(UserDTO user);
    
    public ResponseEntity getUser();
    
    public ResponseEntity updateUser(Long id, UserDTO user);
    
    public ResponseEntity deleteUser(Long id);
    
}
