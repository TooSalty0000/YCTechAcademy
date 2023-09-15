package com.example.sns.order.service;

import com.example.sns.order.domain.Post;
import com.example.sns.order.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post addPost(String title, String content) {
        return null;
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }

    @Override
    public List<Post> getPostListByUserId() {
        return new ArrayList<>();
    }

    @Override
    public List<Post> getPostList() {
        return new ArrayList<>();
    }

}
