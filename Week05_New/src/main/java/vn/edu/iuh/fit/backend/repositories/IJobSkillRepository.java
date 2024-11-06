package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.JobSkillId;

@Repository
public interface IJobSkillRepository extends PagingAndSortingRepository<JobSkill, JobSkillId>, CrudRepository<JobSkill, JobSkillId> {
    @Modifying
    @Query("delete from JobSkill js where js.job.id =: jobID and js.skill.id =: skillID")
    boolean deleteByJobIdAndSkillId(@Param("jobID") long jobID, @Param("skillID") long skillIID);
}
