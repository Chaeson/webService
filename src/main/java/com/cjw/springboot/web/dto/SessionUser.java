package com.cjw.springboot.web.dto;

import com.cjw.springboot.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
// * 소셜 로그인 세션 유지할때 Request전달하는 Instance가 Serializable로 설정되어야 정상적으로 요청된다.
// Spring이 serial형태로 인스턴스를 관리하기 때문이다. Redis에도 동일하다.
// [참고] https://www.programmersought.com/article/4497240555/
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
