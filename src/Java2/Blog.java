package Java2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Blog {
    private List<BlogPost> blogPosts;
    private Map<String, Person> authors; // Store people as a Map<authorId, Person>

    public Blog(List<BlogPost> blogPosts, List<Person> people) {
        this.blogPosts = blogPosts;
        this.authors = people.stream()
                .collect(Collectors.toMap(Person::getId, person -> person)); // Convert list to map
    }

    public List<String> getPostsByAuthorAge(Integer age) {
        return blogPosts.stream()
                .filter(post -> {
                    Person author = authors.get(post.getAuthorId());
                    return author != null && author.getAge().equals(age);
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}
