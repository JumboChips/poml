package com.jumbochips.poml_jpa.comment.repository;

import com.jumbochips.poml_jpa.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findAllByBlogId(Long blogId);
}
