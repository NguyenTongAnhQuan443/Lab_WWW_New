package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Skill;

import java.util.List;

@Repository
public interface ISkillRepository extends PagingAndSortingRepository<Skill, Long>, CrudRepository<Skill, Long> {
    boolean deleteSkillById(long id);

    @Query("select s from Skill s where s.id not in (select c.skill.id from CandidateSkill cs where cs.can.id =: candidateID)")
    List<Skill> findSkillCandidateShouldLearn(@Param("candidateID") long candidateID);
}
