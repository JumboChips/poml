package com.jumbochips.poml_jpa.guestBook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestBookResponseDto {
    private Long guestBookId;
     private String name;
     private String content;
     private LocalDateTime createdAt;
}
