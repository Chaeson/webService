package com.cjw.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)          // 어노테이션이 생성될 수 있는 위치.
                                        // PRAMETER의 경우 선언된 객체에서만 사용가능.
@Retention(RetentionPolicy.RUNTIME)     // 어노테이션 클래스로 지정한다.
public @interface LoginUser {
}
