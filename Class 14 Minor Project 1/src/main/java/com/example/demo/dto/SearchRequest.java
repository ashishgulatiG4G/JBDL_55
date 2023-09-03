package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchRequest {


    // List<String> searchKeys = ["authorName", "Genre"]
    // List<String> searchValues = ["Robert", "Mathematics"]

    @NotBlank
    private String searchKey;

    @NotBlank
    private String searchValue;

}
