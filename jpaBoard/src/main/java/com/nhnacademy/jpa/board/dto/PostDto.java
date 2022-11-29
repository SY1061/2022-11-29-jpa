package com.nhnacademy.jpa.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private final Long id;

    private final String title;

    private final String username;

    @Setter
    private String modifyName;

    private String content;

    private final LocalDateTime timestamp;

    private LocalDateTime modifyTime;

    private final Long commentCount;

    public PostDto(Long id, String title, String username, String content,
                   LocalDateTime timestamp, LocalDateTime modifyTime, Long commentCount) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
        this.timestamp = timestamp;
        this.modifyTime = modifyTime;
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", modifyName='" + modifyName + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", modifyTime=" + modifyTime +
                ", commentCount=" + commentCount +
                '}';
    }
}
