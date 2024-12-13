package com.jumbochips.poml_jpa.guestBook.service;

import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;
import com.jumbochips.poml_jpa.guestBook.dto.GuestBookRequestDto;
import com.jumbochips.poml_jpa.guestBook.dto.GuestBookResponseDto;
import com.jumbochips.poml_jpa.guestBook.dto.UpdateGuestBookRequestDto;
import com.jumbochips.poml_jpa.guestBook.repository.GuestbookRepository;
import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultGuestbookService implements GuestBookService {

    private final GuestbookRepository guestBookRepository;
    private final UserRepository userRepository;


    @Override
    public List<GuestBookResponseDto> getAllGuestBooks(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return guestBookRepository.findAllByUserId(userId).stream()
                .map(guestBook -> GuestBookResponseDto.builder()
                        .guestBookId(guestBook.getId())
                        .name(guestBook.getVisitorName())
                        .content(guestBook.getContent())
                        .createdAt(guestBook.getCreatedAt())
                        .build())
                .toList();
    }

    @Override
    public GuestBookResponseDto createGuestbook(Long userId, GuestBookRequestDto guestBookRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));

        GuestBook guestBook = GuestBook.builder()
                .user(user)
                .isPublic(guestBookRequestDto.getIsPublic())
                .password(guestBookRequestDto.getPassword())
                .visitorName(guestBookRequestDto.getName())
                .content(guestBookRequestDto.getContent())
                .build();

        guestBookRepository.save(guestBook);

        return GuestBookResponseDto.builder()
                .guestBookId(guestBook.getId())
                .name(guestBook.getVisitorName())
                .content(guestBook.getContent())
                .createdAt(guestBook.getCreatedAt())
                .build();
    }

    @Override
    public GuestBookResponseDto updateGuestbook(UpdateGuestBookRequestDto updateGuestBookRequestDto) {
        GuestBook guestBook = guestBookRepository.findById(updateGuestBookRequestDto.getGuestBookId())
                .orElseThrow(() -> new IllegalArgumentException("guestBook not found"));

        guestBook.updateContent(updateGuestBookRequestDto.getContent());
        return GuestBookResponseDto.builder()
                .guestBookId(guestBook.getId())
                .name(guestBook.getVisitorName())
                .content(guestBook.getContent())
                .createdAt(guestBook.getCreatedAt())
                .build();
    }

    @Override
    public void deleteGuestbook(Long guestBookId) {
        if (!guestBookRepository.existsById(guestBookId)) {
            throw new IllegalArgumentException("GuestBook not found with ID: " + guestBookId);
        };
        guestBookRepository.deleteById(guestBookId);
    }
}
