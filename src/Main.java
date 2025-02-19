import Java2.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON files
            List<Person> people = objectMapper.readValue(new File("D:/Lambton/sem-3/Java/Assignment2_C0928316/src/person.json"), new TypeReference<List<Person>>() {});
            List<BlogPost> blogPosts = objectMapper.readValue(new File("D:/Lambton/sem-3/Java/Assignment2_C0928316/src/blogPosts.json"), new TypeReference<List<BlogPost>>() {});

            // Create Blog instance
            Blog blog = new Blog(blogPosts, people);

            // Get blog post IDs by author age
            List<String> postsByAge = blog.getPostsByAuthorAge(28);
            System.out.println("Blog Posts by Authors aged 28: " + postsByAge);

            // Print total blog posts and unique contributors
            System.out.println("Total blog posts: " + blogPosts.size());
            System.out.println("Total unique authors: " + people.size());

        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}
