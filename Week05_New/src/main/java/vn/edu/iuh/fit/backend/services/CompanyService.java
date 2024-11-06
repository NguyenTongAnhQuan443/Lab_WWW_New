package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.ICompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private ICompanyRepository iCompanyRepository;

    @Autowired
    public CompanyService(ICompanyRepository iCompanyRepository) {
        this.iCompanyRepository = iCompanyRepository;
    }

    @Transactional
    public boolean insert(Company company) {
        iCompanyRepository.save(company);
        return true;
    }

    @Transactional
    public boolean update(Company company) {
        iCompanyRepository.save(company);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iCompanyRepository.deleteCompanyById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Company> findOne(long id) {
        return iCompanyRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Company> findAll(int pageNumber, int pageSize) {
        return iCompanyRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("id").descending())
        ).getContent();
    }
}
