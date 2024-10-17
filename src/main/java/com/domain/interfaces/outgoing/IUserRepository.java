package com.domain.interfaces.outgoing;

import com.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserRepository {
    
    public ResponseEntity createUser(User user);
    
    public ResponseEntity getUSer();
    
    public ResponseEntity updateUser(User user);
    
    public ResponseEntity deleteUser(Long id);
    
}
