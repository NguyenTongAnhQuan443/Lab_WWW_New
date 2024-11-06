package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Candidate;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Long> {
    boolean deleteCandidateById(long id);
    Optional<Candidate> findCandidateByUsernameAndPassword(String userName, String password);

    @Query("select c from Candidate c join c.candidateSkills ck join ck.skill s join s.jobSkills js join js.job j where j.id =: jobID and c.address.city = j.company.address.city")
    List<Candidate> findCadidatesMatchWithJobs(@Param("jobID") long id);
}
