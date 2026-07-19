import org.example.AviaSouls;
import org.example.Ticket;
import org.example.TicketTimeComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAvia {

    Ticket t1 = new Ticket("MSK", "SPB", 7000, 1000, 1200); //2 часа
    Ticket t2 = new Ticket("MSK", "SPB", 5000, 900, 1300);  //4 часа
    Ticket t3 = new Ticket("MSK", "SPB", 6000, 1000, 1100); //1 час
    Ticket t4 = new Ticket("MSK", "KZN", 4000, 1000, 1200);

    @Test
    public void shouldCompareByPrice() {
        assertTrue(t2.compareTo(t1) < 0);
        assertTrue(t1.compareTo(t2) > 0);
        assertEquals(0, t1.compareTo(
                new Ticket("MSK", "SPB", 7000, 1500, 1700)
        ));
    }

  /*  @Test
    public void shouldSearchAndSortByPrice() {
        AviaSouls manager = new AviaSouls();

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket[] expected = {t1, t2, t3};
        Ticket[] actualByPrice = manager.searchAndSortBy("MSK", "SPB", comparator);
        assertArrayEquals(expected, actualByPrice);
    }
*/
    @Test
    public void shouldCompareByFlightTime() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        assertTrue(comparator.compare(t3, t1) < 0);
        assertTrue(comparator.compare(t1, t2) < 0);
        assertTrue(comparator.compare(t2, t3) > 0);
    }

    @Test
    public void shouldSearchAndSortByFlightTime() {
        AviaSouls manager = new AviaSouls();

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {t3, t1, t2};
        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);

        assertArrayEquals(expected, actual);
    }
}