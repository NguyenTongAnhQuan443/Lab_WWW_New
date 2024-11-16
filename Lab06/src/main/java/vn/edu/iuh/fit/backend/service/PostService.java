package vn.edu.iuh.fit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.model.Post;
import vn.edu.iuh.fit.backend.repository.IPostRepository;

import java.util.Optional;

@Service
public class PostService {
    private IPostRepository iPostRepository;

    @Autowired
    public PostService(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    public Optional<Post> findById(long id){
        return iPostRepository.findById(id);
    }
}
