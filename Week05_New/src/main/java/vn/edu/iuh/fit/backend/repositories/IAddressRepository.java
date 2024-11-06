package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.edu.iuh.fit.backend.models.Address;

public interface IAddressRepository extends PagingAndSortingRepository<Address, Long> {
    boolean deleteAddressById(long id);
}
