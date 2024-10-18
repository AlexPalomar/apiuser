
package com.app.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginDTO {
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String email;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
    
    
}
