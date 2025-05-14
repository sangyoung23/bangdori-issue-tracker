package bangdori.issueTracker.domain.issue.entity;

import bangdori.issueTracker.comm.entity.BaseEntity;
import bangdori.issueTracker.domain.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@Table(name = "TB_ISSUE_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Issue extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_no")
    private Long issueNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User writer;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "current_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus current_status;

    @Builder
    public Issue(User writer, String title, String description, IssueStatus current_status) {
        this.writer = writer;
        this.title = title;
        this.description = description;
        this.current_status = current_status;
    }
}
