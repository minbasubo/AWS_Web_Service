package com.AWS_Web_Service.admin.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // jpa entity 클래스들이 이 어노테이션이 달린 클래스를 상속할 경우 필드들도 칼럼으로 인식하게 만들어줌
@EntityListeners(AuditingEntityListener.class) // 클래스에 Auditing 기능을 포함시킴
public class BaseTimeEntity { // 모든 entity의 상위 클래스가 되어 entitiy들의 createDate, modifiedDate를 자동으로 관리

    @CreatedDate // entity가 생성되어 저장될 때 시간을 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 entity의 값을 변경할 때 시간이 자동 저장
    private LocalDateTime modifiedDate;
}
