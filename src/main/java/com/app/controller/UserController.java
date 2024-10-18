
package com.app.controller;
import com.app.dto.UserDTO;
import com.domain.interfaces.incoming.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{
    
    private final IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserDTO user){
        ResponseEntity response = iUserService.createUser(user);
        return response;
         
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @GetMapping("/user")
    public ResponseEntity getUser(){
        ResponseEntity response = iUserService.getUser();
        return response;
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestParam(value = "id") 
        Long id, @RequestBody UserDTO user){
        ResponseEntity response = iUserService.updateUser(id, user);
        return response;
    }
    
    @Operation(security = @SecurityRequirement(name = "bearer-key"))
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam(value = "id") 
        Long id){
        ResponseEntity response = iUserService.deleteUser(id);
        return response;
    }
}
