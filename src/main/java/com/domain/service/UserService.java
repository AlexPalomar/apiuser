
package com.domain.service;
import com.app.dto.UserDTO;
import com.domain.interfaces.incoming.IUserService;
import com.domain.model.User;
import com.infra.repository.ImpUSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    
    private final ImpUSer impUser;
    
    @Autowired
    public UserService(ImpUSer impUser){
        this.impUser = impUser;
    }
     
    @Override
    public ResponseEntity createUser(UserDTO userDto) {
        User user = new User(
                userDto.getName(),
                userDto.getFirstName(),
                userDto.getPhone()
        );
        user.setFechaEntregaDay(2L);
        ResponseEntity response = impUser.createUser(user);
        return response;
    }

    @Override
    public ResponseEntity getUser() {
        ResponseEntity response = impUser.getUSer();
        return response;
    }

    @Override
    public ResponseEntity updateUser(Long id, UserDTO userDto) {
        User user = new User(
                userDto.getName(),
                userDto.getFirstName(),
                userDto.getPhone()
        );
        user.setId(id);
        ResponseEntity response = impUser.updateUser(user);
        return response;
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        ResponseEntity response = impUser.deleteUser(id);
        return response;
    }

    
}
