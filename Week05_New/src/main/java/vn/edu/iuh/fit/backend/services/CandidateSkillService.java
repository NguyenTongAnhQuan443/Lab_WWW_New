package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.CandidateSkillId;
import vn.edu.iuh.fit.backend.repositories.ICandidateSkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService {

    private ICandidateSkillRepository iCandidateSkillRepository;

    @Autowired
    public CandidateSkillService(ICandidateSkillRepository iCandidateSkillRepository) {
        this.iCandidateSkillRepository = iCandidateSkillRepository;
    }

    @Transactional
    public boolean insert(CandidateSkill candidateSkill) {
        iCandidateSkillRepository.save(candidateSkill);
        return true;
    }

    @Transactional
    public boolean update(CandidateSkill candidateSkill) {
        iCandidateSkillRepository.save(candidateSkill);
        return true;
    }

    @Transactional
    public boolean delete(long canID, long skillID) {
        return iCandidateSkillRepository.deleteCandidateSkillByCanAndSkill(canID, skillID);
    }

    @Transactional(readOnly = true)
    public Optional<CandidateSkill> findOne(long canID, long skillID) {
        return iCandidateSkillRepository.findById(new CandidateSkillId(canID, skillID));
    }

    @Transactional(readOnly = true)
    public List<CandidateSkill> findAll(int pageNumber, int pageSize) {
        return iCandidateSkillRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("candidate").descending().and(Sort.by("skill")))
        ).getContent();
    }
}
