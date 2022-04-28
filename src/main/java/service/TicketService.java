package service;

import entity.Ticket;
import org.hibernate.SessionFactory;
import repository.SessionFactorySingleton;
import repository.impl.TicketRepositoryImpl;

import java.util.List;


public class TicketService extends GenericService<Ticket,Integer>{
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    private TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();

    public List<Ticket> findAll(){
        try (var session = sessionFactory.getCurrentSession()) {
            var transaction = session.getTransaction();
            try {
                transaction.begin();
                List<Ticket> tickets = ticketRepository.findAll();
                transaction.commit();
                return tickets;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
