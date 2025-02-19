package test;

import Java2.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {

    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("101")
                .authorId("1")
                .postContent("This is a test post")
                .build();

        assertNotNull(post);
        assertEquals("101", post.getId());
    }

    @Test
    void testBlogPostWithNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BlogPost.builder().id(null).authorId("1").postContent("Test Post").build()
        );
        assertEquals("ID cannot be null", exception.getMessage());
    }

    @Test
    void testBlogPostWithNullAuthorIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BlogPost.builder().id("101").authorId(null).postContent("Test Post").build()
        );
        assertEquals("Author ID cannot be null", exception.getMessage());
    }
}