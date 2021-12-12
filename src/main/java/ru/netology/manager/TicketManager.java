package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data

public class TicketManager {
    private TicketRepository repository;

    public void add(FlightOffer ticket) {
        repository.save(ticket);
    }

    public FlightOffer[] findAll(String departureAirport, String arrivalAirport) {
        FlightOffer[] result = new FlightOffer[0];

        for (FlightOffer ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDepartureAirport().equals(departureAirport) && ticket.getArrivalAirport().equals(arrivalAirport)) {
                FlightOffer[] tmp = new FlightOffer[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public FlightOffer[] findDepartureAirport (String DepartureAirport) {
        FlightOffer[] result = new FlightOffer[0];

        for (FlightOffer ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDepartureAirport().equals(DepartureAirport)) {
                FlightOffer[] tmp = new FlightOffer[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
