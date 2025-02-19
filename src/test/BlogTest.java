package test;

import Java2.Blog;
import Java2.BlogPost;
import Java2.Person;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogTest {
    @Test
    void testGetPostsByAuthorAge_ValidCase() {
        Person author1 = new Person("1", "Pranav", "Goswami", 28, "Male");
        Person author2 = new Person("2", "Anant", "Sirsath", 25, "<ale");
        BlogPost post1 = new BlogPost("101", "1", "Setting up content1");
        BlogPost post2 = new BlogPost("102", "2", "Setting up content2.");
        Blog blog = new Blog(Arrays.asList(post1, post2), Arrays.asList(author1, author2));

        List<String> result = blog.getPostsByAuthorAge(28);
        assertEquals(Collections.singletonList("101"), result);
    }

    @Test
    void testGetPostsByAuthorAge_EmptyList() {
        Blog blog = new Blog(Collections.emptyList(), Collections.emptyList());
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testGetPostsByAuthorAge_MissingAuthor() {
        BlogPost post = new BlogPost("101", "3","Demo Content"); // Author ID "3" does not exist
        Blog blog = new Blog(Collections.singletonList(post), Collections.emptyList());

        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(Collections.emptyList(), result);
    }
}
