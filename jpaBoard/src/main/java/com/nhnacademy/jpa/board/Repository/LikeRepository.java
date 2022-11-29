package com.nhnacademy.jpa.board.Repository;

import com.nhnacademy.jpa.board.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Like.Pk> {
}
