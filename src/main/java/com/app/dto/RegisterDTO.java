
package com.app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    String name;
    String password;
    String firstName;
    String phone;
    
    @NotNull(message = "'email' no puede ser nulo.")
    String email;
}
