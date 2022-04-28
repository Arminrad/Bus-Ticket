package repository.impl;

import entity.Ticket;
import org.hibernate.SessionFactory;
import repository.SessionFactorySingleton;
import repository.TicketRepository;

import java.util.List;

public class TicketRepositoryImpl extends GenericRepositoryImpl<Ticket,Integer> implements TicketRepository {
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public TicketRepositoryImpl() {
        super(Ticket.class);
    }

    @Override
    public List<Ticket> findAll() {
        var session = sessionFactory.getCurrentSession();
        try{
            return session
                    .createQuery("select t from Ticket t", Ticket.class)
                    .list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
