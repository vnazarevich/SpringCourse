package com.epam.spring.club.DAO.interfaces;
import java.util.List;

public interface ClientTicketRepository {
    List<String> getBookedTickets(String userId);

    String addTicket(String userId, String ticketId);
}
