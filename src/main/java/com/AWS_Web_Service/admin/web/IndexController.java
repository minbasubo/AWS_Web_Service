package com.AWS_Web_Service.admin.web;

import com.AWS_Web_Service.admin.service.posts.PostsService;
import com.AWS_Web_Service.admin.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { // Model = 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장 가능
        model.addAttribute("posts", postsService.findAllDesc()); // 여기선 postsService.findAllDesc()로 가져온 결과를 index에 전달한다.
        return "index"; // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정된다.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
