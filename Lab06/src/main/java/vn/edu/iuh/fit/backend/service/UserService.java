package vn.edu.iuh.fit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.model.User;
import vn.edu.iuh.fit.backend.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public Optional<User> findUSerByEmail(String email){
        return iUserRepository.findByEmail(email);
    }
}
