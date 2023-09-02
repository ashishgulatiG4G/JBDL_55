package com.example.demojpa.dto;

import com.example.demojpa.model.Admin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String name;

    public Admin toAdmin() {
        return Admin.builder()
                .name(this.name)
                .build();

    }

}
