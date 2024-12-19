package com.jumbochips.poml_jpa.guestBook.service;

import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;
import com.jumbochips.poml_jpa.guestBook.dto.GuestBookRequestDto;
import com.jumbochips.poml_jpa.guestBook.dto.GuestBookResponseDto;
import com.jumbochips.poml_jpa.guestBook.dto.UpdateGuestBookRequestDto;

import java.util.List;

public interface GuestBookService {
    List<GuestBookResponseDto> getAllGuestBooks();
    GuestBookResponseDto createGuestbook (GuestBookRequestDto guestBookRequestDto);
    GuestBookResponseDto updateGuestbook (UpdateGuestBookRequestDto updateGuestBookRequestDto);
    void deleteGuestbook (Long guestBookId);
}
