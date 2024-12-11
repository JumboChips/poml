package com.jumbochips.poml_jpa.guestBook.domain;

import com.jumbochips.poml_jpa.user.domain.User;
import jakarta.persistence.*;

@Entity
public class GuestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String visitorName;
    private String content;
    private Boolean isPublic;

    // 서비스 로직
    public void updateContent(String content) {
        this.content = content;
    }
}
