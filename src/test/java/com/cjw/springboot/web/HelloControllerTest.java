package com.cjw.springboot.web;

import com.cjw.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

// JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킨다. => 스프링 부트 테스트와 JUnit간의 연결자
@RunWith(SpringRunner.class)
// Web기능에 중점을 둔 어노테이션이다.
// @Controller, @ControllerAdvice 등 Controller기능'만'을 사용할 수 있다.
// @WebMvcTest -> @Repository, @Service, @Component는 스캔 대상이 아니어서 Test코드에서 Oauth관련 Service를 찾지 못해 에러가 발생한다.
/** WebMvcTest는 @Configuration은 스캔하지 않는다! **/
@WebMvcTest(controllers = HelloController.class,
            excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
            })
public class HelloControllerTest {

    // Bean을 주입.
    @Autowired
    // 웹 API테스트.
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
    public void HelloController_리턴테스트() throws Exception{
        String hello="hello";

        mvc.perform(get("/hello"))              // HTTP GET요청
                .andExpect(status().isOk())                // mvc.perform의 상태 결과를 검증
                .andExpect(content().string(hello));       // mvc.perform의 응답 결과를 검증
    }

    @Test
    @WithMockUser(roles = "USER")
    public void helloDto_매핑테스트() throws Exception {
        String name="hello";
        int amount=1000;

        mvc.perform(
                get("/hello/dto")
                    .param("name",name)
                    .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
