
package com.domain.interfaces.outgoing.auth;

import com.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface IAuthRepository{
    ResponseEntity register(User user );
    ResponseEntity login(String email, String password);
//    Authentication authenticationManager(String email, String password);
//    Response<Client> getByUserEmail(String email);
}
