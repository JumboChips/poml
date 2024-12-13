package com.jumbochips.poml_jpa.guestBook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGuestBookRequestDto {
    private Long guestBookId;
    private String name;
    private String password;
    private Boolean isPublic;
    private String content;
}
