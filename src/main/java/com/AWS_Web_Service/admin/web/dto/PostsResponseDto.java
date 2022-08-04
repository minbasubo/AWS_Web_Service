package com.AWS_Web_Service.admin.web.dto;

import com.AWS_Web_Service.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto { // 조회를 위한 Dto

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
