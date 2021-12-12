package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private FlightOffer one = new FlightOffer(1, 999, "DME", "KZN", 95);
    private FlightOffer two = new FlightOffer(2, 1399, "SVO", "KZN", 105);
    private FlightOffer three = new FlightOffer(3, 1199, "VKO", "KZN", 100);
    private FlightOffer four = new FlightOffer(4, 1099, "DME", "KZN", 130);

    @BeforeEach
    void SetUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
    }

    @Test
    void shouldFindCertainParameter() {
        FlightOffer[] actual = manager.findAll("DME", "KZN");
        FlightOffer[] expected = {
                one,
                four
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFromDepartureAirport() {
        FlightOffer[] actual = manager.findDepartureAirport("SVO");
        FlightOffer[] expected = {
                two
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByWrongParameter() {
        FlightOffer[] actual = manager.findAll("BQS", "TYD");
        FlightOffer[] expected = {};
        assertArrayEquals(expected, actual);
    }
}