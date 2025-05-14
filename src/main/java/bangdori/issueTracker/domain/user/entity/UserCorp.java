package bangdori.issueTracker.domain.user.entity;

import bangdori.issueTracker.comm.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Getter
@Table(name = "TB_USER_CORP_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCorp extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corp_no")
    private Long corpNo;

    @Column(name = "corp_nm")
    private String corpNm;

    @OneToMany(mappedBy = "userCorp", fetch = FetchType.LAZY)
    private List<User> userList;

    @Builder
    public UserCorp(String corpNm, List<User> userList) {
        this.corpNm = corpNm;
        this.userList = userList;
    }
}
