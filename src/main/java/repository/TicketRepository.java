package repository;

import entity.Ticket;

import java.util.List;

public interface TicketRepository {
    List<Ticket> findAll();
}
