package com.jumbochips.poml_jpa.comment.service;

import com.jumbochips.poml_jpa.comment.domain.Comment;
import com.jumbochips.poml_jpa.guestBook.domain.GuestBook;

public interface CommentService {
    void createComment (Comment comment);
    void updateComment (Long commentId, String newContent);
    void deleteComment (Long commentId);
}
