package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.model.User;

import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String emmail);
}
