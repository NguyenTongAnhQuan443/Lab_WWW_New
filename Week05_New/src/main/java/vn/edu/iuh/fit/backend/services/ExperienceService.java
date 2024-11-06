package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Experience;
import vn.edu.iuh.fit.backend.repositories.IExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {
    private IExperienceRepository iExperienceRepository;

    @Autowired
    public ExperienceService(IExperienceRepository iExperienceRepository) {
        this.iExperienceRepository = iExperienceRepository;
    }

    @Transactional
    public boolean insert(Experience experience) {
        iExperienceRepository.save(experience);
        return true;
    }

    @Transactional
    public boolean update(Experience experience) {
        iExperienceRepository.save(experience);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iExperienceRepository.deleteExperienceById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Experience> findOne(long id) {
        return iExperienceRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Experience> findAll(int pageNumber, int pageSize) {
        return iExperienceRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("id").descending())
        ).getContent();
    }
}
