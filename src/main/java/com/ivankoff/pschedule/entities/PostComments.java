package com.ivankoff.pschedule.entities;


import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity(name="PostComments")
@Table(name="POST_COMMENTS")
public class PostComments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pc_id")
    private Long pcId;
    @Column(name="pc_review")
    private String pcReview;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pc_post_id")
    private Post post;

    public PostComments(String review) {
        this.pcReview = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PostComments)) return false;

        PostComments that = (PostComments) o;

        return pcId != null && pcId.equals(((PostComments) o).pcId);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public PostComments() {
        System.out.print("DBuG: default constructor of PostComments was engaged.");
    }

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public String getPcReview() {
        return pcReview;
    }

    public void setPcReview(String pcReview) {
        this.pcReview = pcReview;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostComments{" +
                "pcId=" + pcId +
                ", pcReview='" + pcReview + '\'' +
                ", post=" + post +
                '}';
    }
}
