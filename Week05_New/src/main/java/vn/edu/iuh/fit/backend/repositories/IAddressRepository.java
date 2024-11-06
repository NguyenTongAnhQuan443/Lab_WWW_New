package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Address;

@Repository
public interface IAddressRepository extends PagingAndSortingRepository<Address, Long> {
    boolean deleteAddressById(long id);
}
