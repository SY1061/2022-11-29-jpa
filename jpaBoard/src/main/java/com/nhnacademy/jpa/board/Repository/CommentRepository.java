package com.nhnacademy.jpa.board.Repository;

import com.nhnacademy.jpa.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
