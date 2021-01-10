package com.cjw.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    // Data Setting은 Builder를 통해 관리하는게 좋다.
    // @Setter는 DB와 가장 근접한 영역이어서 Builder에서 세팅후 저장하는게 안정적이다.
    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title=title;
        this.content=content;
    }
}
