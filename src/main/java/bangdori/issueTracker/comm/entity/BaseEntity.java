package bangdori.issueTracker.comm.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity extends BaseTimeEntity {
    // 향후 공통 필드 추가
}
