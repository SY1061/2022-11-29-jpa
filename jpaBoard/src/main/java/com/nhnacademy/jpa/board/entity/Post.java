package com.nhnacademy.jpa.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Posts")
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "modify_id")
    @Setter
    private User modifyUser;

    @Column(name = "content")
    @Setter
    private String content;

    @Column(name = "comment_count")
    @Setter
    private Long commentCount;

    @Column(name = "created_at")
    private LocalDateTime timestamp;

    @Column(name = "modify_at")
    @Setter
    private LocalDateTime modifyTimestamp;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    public Post(Long id, String title, User user, User modifyUser, String content,
                Long commentCount, LocalDateTime timestamp, LocalDateTime modifyTimestamp) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.modifyUser = modifyUser;
        this.content = content;
        this.commentCount = commentCount;
        this.timestamp = timestamp;
        this.modifyTimestamp = modifyTimestamp;
    }
}
