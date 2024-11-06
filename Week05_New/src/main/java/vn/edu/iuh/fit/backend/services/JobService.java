package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.repositories.IJobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private IJobRepository iJobRepository;

    @Autowired
    public JobService(IJobRepository iJobRepository) {
        this.iJobRepository = iJobRepository;
    }

    @Transactional
    public boolean insert(Job job) {
        iJobRepository.save(job);
        return true;
    }

    @Transactional
    public boolean update(Job job) {
        iJobRepository.save(job);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iJobRepository.deleteJobById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Job> findOne(long id) {
        return iJobRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Job> findAll(int pageNumber, int pageSize) {
        return iJobRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("id").descending())
        ).getContent();
    }
}
