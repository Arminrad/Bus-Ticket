package repository.impl;

import entity.Customer;
import org.hibernate.SessionFactory;
import repository.CustomerRepository;
import repository.SessionFactorySingleton;

import java.util.List;

public class CustomerRepositoryImpl extends GenericRepositoryImpl<Customer,Integer> implements CustomerRepository {
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public CustomerRepositoryImpl() {
        super(Customer.class);
    }

    @Override
    public List<Customer> findAll() {
        var session = sessionFactory.getCurrentSession();
        try{
            return session
                    .createQuery("select c from Customer c", Customer.class)
                    .list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Customer findByUserName(String userName) {
        var session = sessionFactory.getCurrentSession();
        try{
            return session
                    .createQuery("select c from Customer c where c.nationalCode = :userName",Customer.class)
                    .setParameter("userName", userName)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

