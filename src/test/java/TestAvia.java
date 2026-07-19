import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAvia {

    Ticket t1 = new Ticket("MSK", "SPB", 7000, 1000, 1200);
    Ticket t2 = new Ticket("MSK", "SPB", 5000, 900, 1300);
    Ticket t3 = new Ticket("MSK", "KZN", 4000, 1000, 1200);

    @Test
    public void shouldReturnPrice() {
        assertEquals(7000, t1.getPrice());
    }

    @Test
    public void shouldFindAllTickets() {
        AviaSouls manager = new AviaSouls();

        manager.add(t1);
        manager.add(t2);

        Ticket[] expected = {t1, t2};

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldSearchTickets() {
        AviaSouls manager = new AviaSouls();

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Ticket[] expected = {t1, t2};

        Ticket[] actual = manager.search("MSK", "SPB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenSearchNothing() {
        AviaSouls manager = new AviaSouls();

        manager.add(t1);
        manager.add(t2);

        Ticket[] expected = {};

        Ticket[] actual = manager.search("AAA", "BBB");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEqualsTickets() {
        Ticket first = new Ticket("MSK", "SPB", 7000, 1000, 1200);
        Ticket second = new Ticket("MSK", "SPB", 7000, 1000, 1200);

        assertEquals(first, second);
    }

    @Test
    public void shouldNotEqualsDifferentTickets() {
        assertNotEquals(t1, t2);
    }

    @Test
    public void shouldHaveSameHashCode() {
        Ticket first = new Ticket("MSK", "SPB", 7000, 1000, 1200);
        Ticket second = new Ticket("MSK", "SPB", 7000, 1000, 1200);

        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void shouldCompareTicketsByPrice() {
        Ticket cheap = new Ticket("MSK", "SPB", 5000, 1000, 1200);
        Ticket expensive = new Ticket("MSK", "SPB", 7000, 1000, 1200);

        assertTrue(cheap.compareTo(expensive) < 0);
        assertTrue(expensive.compareTo(cheap) > 0);
        assertEquals(0, cheap.compareTo(
                new Ticket("MSK", "SPB", 5000, 900, 1100)
        ));
    }

    @Test
    public void shouldReturnFlightTime() {
        Ticket ticket = new Ticket("MSK", "SPB", 7000, 1000, 1200);

        assertEquals(1000, ticket.getTimeFrom());
        assertEquals(1200, ticket.getTimeTo());
    }
    @Test
    public void shouldNotEqualNull() {
        assertFalse(t1.equals(null));
    }

    @Test
    public void shouldNotEqualAnotherClass() {
        assertFalse(t1.equals("Ticket"));
    }
}