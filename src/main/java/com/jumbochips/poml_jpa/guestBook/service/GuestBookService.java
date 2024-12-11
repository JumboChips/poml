package com.jumbochips.poml_jpa.guestBook.service;

import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;

public interface GuestBookService {
    void createGuestbook (GuestBook guestBook);
    void updateGuestbook (Long guestBookId, String guestName, String guestPassword, String newContent);
    void deleteGuestbook (Long guestBookId, String guestName, String guestPassword);
}
