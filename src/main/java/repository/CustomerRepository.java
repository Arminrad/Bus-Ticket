package repository;

import entity.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findByUserName(String userName);
}
