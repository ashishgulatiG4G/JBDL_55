package org.example.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserResponse {

    private String name;

    private String username;

    private String email;

    private String password;

    private String authorities;

    private int age;

    private Date createdOn;

    private Date updatedOn;
}
