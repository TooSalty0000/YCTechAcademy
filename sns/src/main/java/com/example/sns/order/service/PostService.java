package com.example.sns.order.service;

import com.example.sns.order.domain.Post;

import java.util.List;

public interface PostService {
        Post addPost(String title, String content);

        Post getPost(Long id);

        List<Post> getPostListByUserId();

        List<Post> getPostList();
}
