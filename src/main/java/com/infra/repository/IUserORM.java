
package com.infra.repository;
import com.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserORM extends JpaRepository<User, Long>{
    
}
