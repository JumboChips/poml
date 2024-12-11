package com.jumbochips.poml_jpa.guestBook.repository;

import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<GuestBook, Long> {
}
