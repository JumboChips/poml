package com.jumbochips.poml_jpa.guestBook.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class GuestBookRequestDto {
    private Long userId;
    private String name;
    private String password;
    private Boolean isPublic;
    private String content;
}
