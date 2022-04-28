package service;

import entity.Customer;
import org.hibernate.SessionFactory;
import repository.SessionFactorySingleton;
import repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerService extends GenericService<Customer,Integer>{
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();

    public List<Customer> findAll(){
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();
                List<Customer> customers = customerRepository.findAll();
                transaction.commit();
                return customers;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public Customer findByUserName(String userName){
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            transaction.begin();
                Customer customer = customerRepository.findByUserName(userName);
                transaction.commit();
                return customer;
        }
    }
}
