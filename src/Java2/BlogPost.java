package Java2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    private BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("ID cannot be null");
        if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}