package com.cjw.springboot.web;
import com.cjw.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @date         2021.01.08
* @author       채종욱
* @description
* 테스트 코드 : 톰캣 실행에 대한 무게를 줄여준다. / 기존 기능의 점검이 가능하다.
*/

// 내용: RestController는 JSON반환하는 컨트롤러로 @ResponseBody + @Controller 의 개념!
@RestController
public class HelloController {

    // 내용: @RequestMapping(value="/hello", method={RequestMethod.GET})의 간소화 코드
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
