package com.jumbochips.poml_jpa.guestBook.service;

import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;
import com.jumbochips.poml_jpa.guestBook.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGuestbookService implements GuestBookService {

    private final GuestbookRepository guestBookRepository;

    @Override
    public void createGuestbook(GuestBook guestBook) {
        guestBookRepository.save(guestBook);
    }

    @Override
    public void updateGuestbook(Long guestBookId, String guestName, String guestPassword, String newContent) {
        GuestBook guestBook = guestBookRepository.findById(guestBookId)
                .orElseThrow(() -> new IllegalArgumentException("GuestBook not found"));
        guestBook.updateContent(newContent);
        guestBookRepository.save(guestBook);
    }

    @Override
    public void deleteGuestbook(Long guestBookId, String guestName, String guestPassword) {
        guestBookRepository.deleteById(guestBookId);
    }
}
