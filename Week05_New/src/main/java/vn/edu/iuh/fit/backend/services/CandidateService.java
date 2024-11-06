package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.repositories.ICandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    private ICandidateRepository iCandidateRepository;

    @Autowired
    public CandidateService(ICandidateRepository iCandidateRepository) {
        this.iCandidateRepository = iCandidateRepository;
    }

    @Transactional
    public boolean insert(Candidate candidate) {
        iCandidateRepository.save(candidate);
        return true;
    }

    @Transactional
    public boolean update(Candidate candidate) {
        iCandidateRepository.save(candidate);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iCandidateRepository.deleteCandidateById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Candidate> findOne(long id) {
        return iCandidateRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Candidate> findAll(int pageNumber, int pageSize, String sortBy, String sortDerection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDerection), sortBy);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return iCandidateRepository.findAll(pageable);
    }
}
