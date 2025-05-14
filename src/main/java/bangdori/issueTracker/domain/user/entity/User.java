package bangdori.issueTracker.domain.user.entity;

import bangdori.issueTracker.domain.issue.entity.Issue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Getter
@Table(name = "TB_USER_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @NotNull
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @NotNull
    @Column(name = "pwd", nullable = false)
    private String pwd;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "role_cd")
    @Enumerated(EnumType.STRING)
    private Role roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corp_no")
    private UserCorp userCorp;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Issue> issues;

    @Builder
    public User(String id ,String pwd, String name, String phoneNo, Role roles, UserCorp userCorp, List<Issue> issues) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phoneNo = phoneNo;
        this.roles = roles;
        this.userCorp = userCorp;
        this.issues = issues;
    }
}
