package web4.web4.dao;

import org.springframework.data.repository.CrudRepository;
import web4.web4.controller.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Iterable<Customer> findAll();
    List<Customer> findByphone(String phone);
}
