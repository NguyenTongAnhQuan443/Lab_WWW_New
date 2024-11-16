package vn.edu.iuh.fit.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.repositories.IJobSkillRepository;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.ids.JobSkillId;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService {
    private IJobSkillRepository jobSkillRepository;

    @Autowired
    public JobSkillService(IJobSkillRepository jobSkillRepository) {
        this.jobSkillRepository = jobSkillRepository;
    }

    public boolean insert(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
        return true;
    }

    public boolean update(JobSkill jobSkill) {
        jobSkillRepository.save(jobSkill);
        return true;
    }

    public boolean delete(long jobID, long skillID) {
        return jobSkillRepository.deleteByJobIdAndSkillId(jobID, skillID);
    }

    public Optional<JobSkill> findOne(long jobID, long skillID) {
        return jobSkillRepository.findById(new JobSkillId(jobID, skillID));
    }

    public List<JobSkill> findAll(int page, int size) {
        return jobSkillRepository.findAll(PageRequest
                .of(page, size, Sort.by("job").descending().and(Sort.by("job")
                        .descending()))).getContent();

    }
}
