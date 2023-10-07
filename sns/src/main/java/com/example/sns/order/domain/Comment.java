package com.example.sns.order.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @Column(name="user_id")
    private Post postId;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private LocalDate createdAt;

    public Comment (Post postId, String content, LocalDate createdAt) {
        this.postId = postId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Comment (Post postId, String content) {
        this.postId = postId;
        this.content = content;
        this.createdAt = LocalDate.now();
    }

    public Comment() {
        super();
    }
}
