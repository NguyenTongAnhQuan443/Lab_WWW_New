package vn.edu.iuh.fit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repository.IPostCommentRepository;

@Service
public class PostCommentService {
    private IPostCommentRepository iPostCommentRepository;

    @Autowired
    public PostCommentService(IPostCommentRepository iPostCommentRepository) {
        this.iPostCommentRepository = iPostCommentRepository;
    }
}
