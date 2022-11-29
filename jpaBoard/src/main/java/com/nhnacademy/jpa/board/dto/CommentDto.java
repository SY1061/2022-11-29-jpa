package com.nhnacademy.jpa.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDto {
    private final Long id;

    private final Long userId;

    private final Long postId;

    private final String username;

    private final String content;

    private final LocalDateTime timestamp;

    public CommentDto(Long id, Long userId, Long postId, String username, String content, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
