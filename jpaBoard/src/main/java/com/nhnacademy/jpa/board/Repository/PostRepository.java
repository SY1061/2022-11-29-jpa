package com.nhnacademy.jpa.board.Repository;

import com.nhnacademy.jpa.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
