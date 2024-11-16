package vn.edu.iuh.fit.backend.util;

import com.github.javafaker.Faker;
import vn.edu.iuh.fit.backend.model.User;
import vn.edu.iuh.fit.backend.model.Post;
import vn.edu.iuh.fit.backend.model.PostComment;
import vn.edu.iuh.fit.backend.repository.IUserRepository;
import vn.edu.iuh.fit.backend.repository.IPostRepository;
import vn.edu.iuh.fit.backend.repository.IPostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IPostCommentRepository postCommentRepository;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    @Override
    public void run(String... args) {
        generateUsers(10);
        generatePosts(20);
        generatePostComments(50);
    }

    private void generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setFirstName(faker.name().firstName());
            user.setMiddleName(faker.name().nameWithMiddle());
            user.setLastName(faker.name().lastName());
            user.setMobile(faker.phoneNumber().cellPhone());
            user.setEmail(faker.internet().emailAddress());
            user.setPasswordHash(faker.internet().password());
            user.setRegisteredAt(Instant.now().minusSeconds(random.nextInt(100000)));
            user.setLastLogin(Instant.now().minusSeconds(random.nextInt(50000)));
            user.setIntro(faker.lorem().sentence(5));
            user.setProfile(faker.lorem().paragraph());
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    private void generatePosts(int count) {
        List<User> users = (List<User>) userRepository.findAll();
        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Post post = new Post();
            post.setAuthor(users.get(random.nextInt(users.size())));
            post.setTitle(faker.book().title());
            post.setMetaTitle(faker.lorem().sentence(3));
            post.setSummary(faker.lorem().sentence(10));
            post.setPublished(random.nextBoolean());
            post.setCreatedAt(Instant.now().minusSeconds(random.nextInt(100000)));
            post.setUpdatedAt(Instant.now());
            post.setPublishedAt(Instant.now().minusSeconds(random.nextInt(50000)));
            post.setContent(faker.lorem().paragraph(3));
            posts.add(post);
        }
        postRepository.saveAll(posts);
    }

    private void generatePostComments(int count) {

//      CHÚ Ý LỖI
        List<Post> posts = (List<Post>) postRepository.findAll();
        List<PostComment> comments = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            PostComment comment = new PostComment();
            comment.setPost(posts.get(random.nextInt(posts.size())));
            comment.setTitle(faker.lorem().sentence(3));
            comment.setPublished(random.nextBoolean());
            comment.setCreatedAt(Instant.now().minusSeconds(random.nextInt(100000)));
            comment.setPublishedAt(Instant.now().minusSeconds(random.nextInt(50000)));
            comment.setContent(faker.lorem().paragraph());
            comments.add(comment);
        }
        postCommentRepository.saveAll(comments);
    }
}
