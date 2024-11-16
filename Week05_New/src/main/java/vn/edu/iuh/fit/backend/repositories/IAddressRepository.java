package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.models.Address;

@Repository
public interface IAddressRepository extends PagingAndSortingRepository<Address, Long>, CrudRepository<Address, Long> {
    public boolean deleteAddressById(long id);
}
