package com.example.sns.order.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
public class Post  {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	public Post() {
		super();
	}

	public Post(LocalDate localDate) {
		//transform localDate to Date
        this.createdAt = localDate;
	}

	public Post(Long userId, String title, String content) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createdAt = LocalDate.now();
	}

	public Post(Long id, Long userId, String title, String content, LocalDate createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}
}
