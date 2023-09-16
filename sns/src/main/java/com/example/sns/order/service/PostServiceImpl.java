package com.example.sns.order.service;

import com.example.sns.order.domain.Post;
import com.example.sns.order.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post addPost(String title, String content) {

        // add post
        Post post = new Post(1L, title, content);
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        // get post by id
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getPostListByUserId() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostList() {
        List<Post> posts = postRepository.findAll();
        // sort by date desc
        return posts
                .stream()
                .sorted(new Comparator<Post>() {
                    @Override
                    public int compare(Post o1, Post o2) {
                        return o2.getCreatedAt().compareTo(o1.getCreatedAt());
                    }
                })
                .toList();
    }

}
