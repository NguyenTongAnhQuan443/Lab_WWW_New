package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.repositories.IAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private IAddressRepository iAddressRepository;

    @Autowired
    public AddressService(IAddressRepository iAddressRepository) {
        this.iAddressRepository = iAddressRepository;
    }

    @Transactional
    public boolean insert(Address address) {
        iAddressRepository.save(address);
        return true;
    }

    @Transactional
    public boolean update(Address address) {
        iAddressRepository.save(address);
        return true;
    }

    @Transactional
    public boolean delete(long id) {
        return iAddressRepository.deleteAddressById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Address> findOne(long id) {
        return iAddressRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Address> findAll(int pageNumber, int pageSize) {
        return iAddressRepository.findAll(
                PageRequest.of(pageNumber, pageSize, Sort.by("id").descending())
        ).getContent();
    }
}
