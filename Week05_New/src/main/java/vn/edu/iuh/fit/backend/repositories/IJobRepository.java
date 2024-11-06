package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Job;

import java.util.List;

@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Long>, CrudRepository<Job, Long> {
    boolean deleteJobById(long id);
    List<Job> findAllByCompanyId(long id);
    @Modifying
    @Query("select j from  Job j join j.jobSkills js join js.skill s join s.candidateSkills cs where cs.can.id =: candidateID and cs.can.address.city = j.company.address.city")
    List<Job> findAllJobMatchWithCandidate(@Param("candidateID") long candidateID);
}
