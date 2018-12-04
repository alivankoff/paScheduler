package com.ivankoff.pschedule.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity(name="Post")
@Table(name="POST")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Long postId;
    @Column(name="post_title")
    private String postTitle;
    @Column(name="post_text")
    private String postText;

    @OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JoinColumn(name="pc_post_id")
    Set<PostComments>comments = new HashSet<>();

    public Post(String postTitle, String postText) {
        this.postTitle = postTitle;
        this.postText = postText;
    }

    public Post() {
        System.out.print("DBuG: default constructor of POST was engaged.");
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Set<PostComments> getComments() {
        return comments;
    }

    public void setComments(Set<PostComments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", comments=" + comments +
                '}';
    }
}
