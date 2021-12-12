package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightOffer;

@AllArgsConstructor
@NoArgsConstructor

public class TicketRepository {
    private FlightOffer[] tickets = new FlightOffer[0];

    public void save(FlightOffer ticket) {
        int length = tickets.length + 1;
        FlightOffer[] tmp = new FlightOffer[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public FlightOffer[] getAll() {
        return tickets;
    }
}
