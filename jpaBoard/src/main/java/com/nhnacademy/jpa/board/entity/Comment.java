package com.nhnacademy.jpa.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime timestamp;

    @Column(name = "parent_id")
    private Long parentId;

    public Comment(Long id, User user, Post post, String content, LocalDateTime timestamp, Long parentId) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.content = content;
        this.timestamp = timestamp;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", parentId=" + parentId +
                '}';
    }
}
