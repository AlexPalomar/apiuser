
package com.infra.repository;

import com.domain.interfaces.outgoing.IUserRepository;
import com.domain.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ImpUSer implements IUserRepository{
    
   
    private final IUserORM userRepository;
    
    @Autowired
    public ImpUSer(IUserORM userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity createUser(User user) {
        try {
            User userResponse = userRepository.save(user);
            return new ResponseEntity(
                userResponse.getId(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getUSer() {
        List userResponse = userRepository.findAll();
        return new ResponseEntity(userResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateUser(User user) {
        try {
            var userResponse = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("user not found"));
            userRepository.save(user);
            return new ResponseEntity("usuario actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
         
        
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        try {
            var userResponse = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
            userRepository.deleteById(id);
            return new ResponseEntity("usuario eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
}
