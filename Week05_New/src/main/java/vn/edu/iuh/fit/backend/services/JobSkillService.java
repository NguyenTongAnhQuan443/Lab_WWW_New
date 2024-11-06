package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.models.JobSkillId;
import vn.edu.iuh.fit.backend.repositories.IJobSkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService {
    private IJobSkillRepository iJobSkillRepository;

    @Autowired
    public JobSkillService(IJobSkillRepository iJobSkillRepository) {
        this.iJobSkillRepository = iJobSkillRepository;
    }

    @Transactional
    public boolean insert(JobSkill jobSkill) {
        iJobSkillRepository.save(jobSkill);
        return true;
    }

    @Transactional
    public boolean update(JobSkill jobSkill) {
        iJobSkillRepository.save(jobSkill);
        return true;
    }

    @Transactional
    public boolean delete(long jobID, long skillID) {
        return iJobSkillRepository.deleteByJobIdAndSkillId(jobID, skillID);
    }

    @Transactional(readOnly = true)
    public Optional<JobSkill> findOne(long jobID, long skillID) {
        return iJobSkillRepository.findById(new JobSkillId(jobID, skillID));
    }

    @Transactional(readOnly = true)
    public List<JobSkill> findAll(int pageNumber, int pageSize) {
        return iJobSkillRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("job").descending().and(Sort.by("job").descending()))
        ).getContent();
    }
}
