package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.model.PostComment;

public interface IPostCommentRepository extends CrudRepository<PostComment, Long> {
    Page<PostComment> findPostCommentByPublishedIsTrueAndPostId(Pageable pageable, long postID);
}
