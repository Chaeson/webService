package com.cjw.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * JAVA 8 이후 수정 시간등 DB로 컨버팅 하는 과정이 단순화 되어 하기 클래스를 통해
 * 자동적으로 생성시간(@CreatedDate), 접근시의 시간(@LastModifiedDate)을 지정해서 관리한다.
 * */
@Getter
@MappedSuperclass                               // JPA Entity 클래스들이 해당 클래스를 상속받은 경우 하위 필드들도 컬럼으로 인식.
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스에 Auditing기능 포함.
public class BaseTimeEntity {
    @CreatedDate                                // Entity생성시 시간이 자동 저장.
    private LocalDateTime createdDate;

    @LastModifiedDate                           // 조회한 Entity의 값을 변경할때 시간이 자동 저장.
    private LocalDateTime modifiedDate;

}
