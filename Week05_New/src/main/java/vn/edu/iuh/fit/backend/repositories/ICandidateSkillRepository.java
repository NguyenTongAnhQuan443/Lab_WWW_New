package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.CandidateSkillId;

import java.util.List;

@Repository
public interface ICandidateSkillRepository extends PagingAndSortingRepository<CandidateSkill, CandidateSkillId>, CrudRepository<CandidateSkill, CandidateSkillId> {
    @Modifying
    @Query("delete from CandidateSkill cs where cs.can.id =: canID and cs.skill.id =: skillID")
    boolean deleteCandidateSkillByCanAndSkill(@Param("canID") long canID, @Param("skillID") long skillID);

    List<CandidateSkill> getCandidateSkillByCan_Id(long candidateID);
}
