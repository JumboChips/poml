package com.jumbochips.poml_jpa.guestBook.controller;

import com.jumbochips.poml_jpa.guestBook.dto.GuestBookRequestDto;
import com.jumbochips.poml_jpa.guestBook.dto.GuestBookResponseDto;
import com.jumbochips.poml_jpa.guestBook.dto.UpdateGuestBookRequestDto;
import com.jumbochips.poml_jpa.guestBook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/guestbook")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @GetMapping
    public ResponseEntity<List<GuestBookResponseDto>> getGuestBooks(
            @RequestBody GuestBookRequestDto guestBookRequestDto
    ) {
        try {
            Long userId = guestBookRequestDto.getUserId();
            guestBookService.getAllGuestBooks();
            return ResponseEntity.ok().body(guestBookService.getAllGuestBooks());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<GuestBookResponseDto> createGuestBook(
            @RequestBody GuestBookRequestDto guestBookRequestDto
    ) {
        try{
            guestBookService.createGuestbook(guestBookRequestDto);
            return ResponseEntity.ok().body(new GuestBookResponseDto());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<GuestBookResponseDto> updateGuestBook(
            @RequestBody UpdateGuestBookRequestDto updateGuestBookRequestDto
    ) {
        try {
            guestBookService.updateGuestbook(updateGuestBookRequestDto);
            return ResponseEntity.ok().body(new GuestBookResponseDto());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{guestBookId}")
    public ResponseEntity<GuestBookResponseDto> deleteGuestBook(
            @PathVariable Long guestBookId) {
        try {
            guestBookService.deleteGuestbook(guestBookId);
            return ResponseEntity.ok().body(new GuestBookResponseDto());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
