package com.seiglu.seigluapi.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthDTO {
    @NotBlank(message = "email is required")
    @Email(message = "e-mail is not valid")
    private String email;
    @NotBlank(message = "password is required")
    private String password;
}
