package com.example.demo.dto;


import com.example.demo.models.Admin;
import com.example.demo.models.SecuredUser;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Admin toAdmin() {
        return Admin.builder()
                .name(this.name)
                .securedUser(SecuredUser.builder().
                        username(this.username).
                        password(this.password).
                        build())
                .email(this.email)
                .build();
    }

}
