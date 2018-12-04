package com.ivankoff.pschedule;


import java.awt.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ivankoff.pschedule.entities.Post;
import com.ivankoff.pschedule.entities.PostComments;
import com.ivankoff.pschedule.repository.PostRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostPostCommentsTests {

    @Autowired
    EntityManager  entityManager;

    @Autowired
    PostRepository postRepository;

    @Test
    public void testPostPostComments() {
        System.out.print("DBuG: PostPostCommentsTests is running");
    }

    @Test
    public void testPostReview() {
        System.out.print("DBuG: ============= stated insert ==================\n\n");

        Post post = new Post("Second Post 300", "Another Test 300");

        post.getComments().add(
                new PostComments("My second review 301")
        );
        post.getComments().add(
                new PostComments("My second review 302")
        );
        post.getComments().add(
                new PostComments("My second review 303")
        );

        postRepository.save(post);
    }

    @Test
    public void testDeletePostReview() {
        System.out.print("DBuG: ============= stated delete ==================\n\n");
        Iterable<Post> posts = postRepository.findAll();
        Long selectedId =0L;
        int i=1;
        for (Post p: posts) {
            selectedId = p.getPostId();
            System.out.print(i+ ". DBuG: "+p.getPostId()+", "+p.getPostTitle()+", "+p.getPostText()+"\n\n");
            i++;
        }
        System.out.print("DBuG: ==============    deleted    ===================\n\n");
        System.out.print("DBuG: last record with id= "+selectedId+"    would be deleted"+"\n\n");
        postRepository.deleteById(selectedId);
    }

    @Test
    public void testSelectWithJpqlQuery() {
        java.util.List<PostComments> comments = entityManager.createQuery(
                "SELECT   pc " +
                        "  FROM   PostComments pc " +
                        " WHERE   pc.post.postId = :postId", PostComments.class)
                .setParameter( "postId", 12L )
                .getResultList();
        System.out.print("\nDBuG: ==============    printing    ===================\n\n");
        int count=1;
        for (PostComments c: comments) {
            System.out.print(count+". DBuG: "+c.getPcId()+", "+c.getPcReview()+", with post=\n"+c.getPost().toString()+"\n\n");
            count++;
        }

    }

}
