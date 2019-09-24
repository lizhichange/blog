package run.halo.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import run.halo.app.model.enums.PostCreateFrom;
import run.halo.app.model.enums.PostStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Post base entity.
 *
 * @author johnniang
 * @author ryanwang
 */
@Data
@Entity(name = "BasePost")
@Table(name = "posts")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BasePost extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Post title.
     */
    @Column(name = "title", columnDefinition = "varchar(100) not null")
    private String title;

    /**
     * Post status.
     */
    @Column(name = "status", columnDefinition = "int default 1")
    private PostStatus status;

    /**
     * Post url.
     */
    @Column(name = "url", columnDefinition = "varchar(255) not null", unique = true)
    private String url;

    /**
     * Original content,not format.
     */
    @Column(name = "original_content", columnDefinition = "text not null")
    private String originalContent;

    /**
     * Rendered content.
     *
     * @see run.halo.app.utils.MarkdownUtils#renderHtml(String)
     */
    @Column(name = "format_content", columnDefinition = "text not null")
    private String formatContent;

    /**
     * Post summary.
     */
    @Column(name = "summary", columnDefinition = "varchar(500) default ''")
    private String summary;

    /**
     * Cover thumbnail of the post.
     */
    @Column(name = "thumbnail", columnDefinition = "varchar(1023) default ''")
    private String thumbnail;

    /**
     * Post visits.
     */
    @Column(name = "visits", columnDefinition = "bigint default 0")
    private Long visits;

    /**
     * Whether to allow comments.
     */
    @Column(name = "disallow_comment", columnDefinition = "int default 0")
    private Boolean disallowComment;

    /**
     * Post password.
     */
    @Column(name = "password", columnDefinition = "varchar(255) default ''")
    private String password;

    /**
     * Custom template.
     */
    @Column(name = "template", columnDefinition = "varchar(255) default ''")
    private String template;

    /**
     * Whether to top the post.
     */
    @Column(name = "top_priority", columnDefinition = "int default 0")
    private Integer topPriority;

    /**
     * Create from,server or WeChat.
     */
    @Column(name = "create_from", columnDefinition = "int default 0")
    private PostCreateFrom createFrom;

    /**
     * Likes
     */
    @Column(name = "likes", columnDefinition = "bigint default 0")
    private Long likes;

    /**
     * Edit time.
     */
    @Column(name = "edit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public String getFormatContent() {
        return formatContent;
    }

    public void setFormatContent(String formatContent) {
        this.formatContent = formatContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public Boolean getDisallowComment() {
        return disallowComment;
    }

    public void setDisallowComment(Boolean disallowComment) {
        this.disallowComment = disallowComment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Integer getTopPriority() {
        return topPriority;
    }

    public void setTopPriority(Integer topPriority) {
        this.topPriority = topPriority;
    }

    public PostCreateFrom getCreateFrom() {
        return createFrom;
    }

    public void setCreateFrom(PostCreateFrom createFrom) {
        this.createFrom = createFrom;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    @Override
    public void prePersist() {
        super.prePersist();

        id = null;

        if (editTime == null) {
            editTime = getCreateTime();
        }

        if (status == null) {
            status = PostStatus.DRAFT;
        }

        if (summary == null) {
            summary = "";
        }

        if (thumbnail == null) {
            thumbnail = "";
        }

        if (disallowComment == null) {
            disallowComment = false;
        }

        if (password == null) {
            password = "";
        }

        if (template == null) {
            template = "";
        }

        if (topPriority == null) {
            topPriority = 0;
        }

        if (createFrom == null) {
            createFrom = PostCreateFrom.ADMIN;
        }

        if (visits == null || visits < 0) {
            visits = 0L;
        }

        if (likes == null || likes < 0) {
            likes = 0L;
        }

        if (formatContent == null) {
            formatContent = "";
        }
    }

}
