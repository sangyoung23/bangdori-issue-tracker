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
@Table(name = "TB_ISSUE_COMMENT_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueComment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_comment_no")
    private Long issueCommentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_no")
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_no")
    private IssueComment parentComment;

    @NotNull
    @Column(name = "comment", nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Builder
    public IssueComment(Issue issue, User writer, IssueComment parentComment, String comment) {
        this.issue = issue;
        this.writer = writer;
        this.parentComment = parentComment;
        this.comment = comment;
    }

}
