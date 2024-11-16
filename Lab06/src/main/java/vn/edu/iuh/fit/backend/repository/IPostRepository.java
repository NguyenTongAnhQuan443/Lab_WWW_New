package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.model.Post;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IPostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findById(Long id);
//    Page<Post> findAllByPublishedIsTrue(Pageable pageable);
//
//    List<Post> findByAuthor_IdAAndPublishedIsTrue(long authorID);
}
