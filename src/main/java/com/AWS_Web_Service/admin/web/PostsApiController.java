package com.AWS_Web_Service.admin.web;

import com.AWS_Web_Service.admin.service.posts.PostsService;
import com.AWS_Web_Service.admin.web.dto.PostsResponseDto;
import com.AWS_Web_Service.admin.web.dto.PostsSaveRequestDto;
import com.AWS_Web_Service.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성해서 스프링의 Bean을 주입 받음
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts") // 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") // 수정
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}") // 조회
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}") // 삭제
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
