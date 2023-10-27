package pl.ug.edu.fiszkord.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.ug.edu.fiszkord.domain.Customer;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByMoney(float money);

    List<Customer> findByDate(Date date);
}
