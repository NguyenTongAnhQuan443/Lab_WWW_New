package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Experience;
@Repository
public interface IExperienceRepository extends PagingAndSortingRepository<Experience, Long>
        , CrudRepository<Experience, Long> {
    public boolean deleteExperienceById(long id);
}
