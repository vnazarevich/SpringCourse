package com.epam.spring.club.DAO.interfaces;

import java.util.List;
import com.epam.spring.club.models.Show;
import com.epam.spring.club.models.Ticket;

public interface TicketRepository {
    Ticket createTicket(String showId, int seat, boolean isVIP, boolean isFree, int price);

    Ticket getTicketById(String id);

    Ticket bookTiket(String ticketId);

    Ticket getTicket(String showId, int seat);

    List<Ticket> getBookedTickets();

    List<Ticket> getBookedTicketsForShow(Show show);
}
