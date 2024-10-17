
package com.domain.interfaces.outgoing.auth;

import com.domain.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAuthORM extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
