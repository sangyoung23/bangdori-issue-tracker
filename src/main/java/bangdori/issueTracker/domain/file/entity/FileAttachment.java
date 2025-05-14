package bangdori.issueTracker.domain.file.entity;

import bangdori.issueTracker.domain.issue.entity.Issue;
import bangdori.issueTracker.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Getter
@Table(name = "TB_FILE_ATTACHMENT_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileAttachment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_attach_no")
    private Long fileAttachNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_no")
    private Issue issue;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "original_file_name", nullable = false)
    private String originalFileName;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "content_type")
    private String contentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User regUser;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public FileAttachment(Issue issue, User regUser, String filePath, String originalFileName,
                          Long fileSize, String contentType, LocalDateTime createdAt) {
        this.issue = issue;
        this.regUser = regUser;
        this.filePath = filePath;
        this.originalFileName = originalFileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.createdAt = createdAt;
    }
}
