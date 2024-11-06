package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.ISkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private ISkillRepository iSkillRepository;

    @Autowired
    public SkillService(ISkillRepository iSkillRepository) {
        this.iSkillRepository = iSkillRepository;
    }

    @Transactional
    public boolean insert(Skill skill) {
        iSkillRepository.save(skill);
        return true;
    }

    @Transactional
    public boolean update(Skill skill) {
        iSkillRepository.save(skill);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iSkillRepository.deleteSkillById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Skill> findOne(long id) {
        return iSkillRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Skill> findAll(int pageNumber, int pageSize) {
        return iSkillRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("id").descending())
        ).getContent();
    }
}
