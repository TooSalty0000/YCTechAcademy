package com.example.sns.service;

import com.example.sns.order.domain.Post;
import com.example.sns.order.repository.PostRepository;
import com.example.sns.order.service.PostService;
import com.example.sns.order.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.extensions.Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        postService = new PostServiceImpl(postRepository);
    }

    @Test
    @DisplayName("add 시 repository 가 호출되는 지 확인")
    public void test_post_add() {
        postService.addPost("test title", "test content");
        verify(postRepository, atLeastOnce()).save(any());
    }

    @Test
    @DisplayName("전체 post 조회")
    public void test_get_posts() {
        Post post1 = new Post(LocalDate.now().minusDays(2L));
        Post post2 = new Post(LocalDate.now().plusDays(2L));
        List<Post> stubPosts = List.of(post1, post2);

        // stubbing
        when(postRepository.findAll()).thenReturn(stubPosts);

        List<Post> posts = postService.getPostList();

        assertTrue(isSortedDescending(posts));

    }

    private boolean isSortedDescending(List<Post> items) {
        return IntStream.range(0, items.size() - 1)
                .noneMatch(i -> items.get(i).getCreatedAt().isBefore(items.get(i + 1).getCreatedAt()));
    }


}
