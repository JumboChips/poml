package com.jumbochips.poml_jpa.comment.domain;

import com.jumbochips.poml_jpa.post.domain.Post;
import com.jumbochips.poml_jpa.user.domain.User;
import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String content;

    // 서비스 로직
    public void updateContent(String content) {
        this.content = content;
    }
}
