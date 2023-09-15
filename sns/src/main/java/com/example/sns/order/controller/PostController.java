package com.example.sns.order.controller;

import com.example.sns.order.controller.dto.PostDto;
import com.example.sns.order.controller.dto.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Post Controller")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Operation(
            summary = "posts",
            description = "Show all posts"
    )
    @GetMapping("/")
    public ResultDto<List<PostDto>> getAllPosts() {
        return null;
    }

    @Operation(
            summary = "/{id}",
            description = "Show post with specific id"
    )
    @GetMapping("/{id}")
    public ResultDto<PostDto> getPostWithId(
            @Parameter(description = "Post ID")
            @PathVariable String id) {

        return null;
    }

    @Operation(
            summary = "posts/new",
            description = "Create new post"
    )
    @PostMapping("/new")
    public ResultDto<PostDto> newPost(@Parameter(name = "dto", description = "post dto")
                                          @RequestBody PostDto dto) {
        return null;
    }
}
