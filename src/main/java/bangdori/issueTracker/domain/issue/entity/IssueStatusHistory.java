package bangdori.issueTracker.domain.issue.entity;

import bangdori.issueTracker.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "TB_ISSUE_STATUS_HISTORY_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueStatusHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_status_history_no")
    private Long issueStatusHistoryNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_no")
    private Issue issue;

    @Column(name = "chg_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus chgStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User chgUser;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public IssueStatusHistory(Issue issue, IssueStatus chgStatus, User chgUser, LocalDateTime updatedAt) {
        this.issue = issue;
        this.chgStatus = chgStatus;
        this.chgUser = chgUser;
        this.updatedAt = updatedAt;
    }
}
