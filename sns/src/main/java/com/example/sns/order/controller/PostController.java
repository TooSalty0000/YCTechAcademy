package com.example.sns.order.controller;

import com.example.sns.order.controller.dto.PostDto;
import com.example.sns.order.controller.dto.ResultDto;
import com.example.sns.order.domain.Post;
import com.example.sns.order.service.PostService;
import com.example.sns.order.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Post Controller")
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;


    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @Operation(
            summary = "posts",
            description = "Show all posts"
    )
    @GetMapping("/")
    public ResultDto<List<PostDto>> getAllPosts() {
        List<PostDto> postDtoList = new ArrayList<PostDto>();
        List<Post> postList = postService.getPostList();
        for (Post post : postList) {
            PostDto postDto = new PostDto(post.getTitle(), post.getContent());
            postDtoList.add(postDto);
        }
        return ResultDto.success(postDtoList);
    }

    @Operation(
            summary = "/{id}",
            description = "Show post with specific id"
    )
    @GetMapping("/{id}")
    public ResultDto<PostDto> getPostWithId(
            @Parameter(description = "Post ID")
            @PathVariable String id) {
        Post post = postService.getPost(Long.parseLong(id));
        if (post == null) {
            return ResultDto.fail("Post not found");
        }
        PostDto postDto = new PostDto(post.getTitle(), post.getContent());

        return ResultDto.success(postDto);
    }

    @Operation(
            summary = "posts/new",
            description = "Create new post"
    )
    @PostMapping("/new")
    public ResultDto<PostDto> newPost(@Parameter(name = "dto", description = "post dto")
                                          @RequestBody PostDto dto) {
        Post post = postService.addPost(dto.title(), dto.content());
        PostDto postDto = new PostDto(post.getTitle(), post.getContent());
        return ResultDto.success(postDto);
    }
}
