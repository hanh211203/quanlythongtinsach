import model.BookImpl;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    static BookImpl book;
    @BeforeAll
    static void init(){
        book = new BookImpl(10001,"1234","Think and Grow Rich",
                "Naoleon Hill",10,"English",2023);
    }
    @Test
    void testGetTitle(){
        String title = book.getTitle();
        assertEquals("Think and Grow Rich",title);
    }
    @Test
    void testSetTitle(){
        book.setTitle("Think and Grow Rich 2");
        String title = book.getTitle();
        assertEquals("Think and Grow Rich 2",title);
    }
    @Test
    void testGetAverage(){
        double average = book.getAverageRating();
        assertEquals(10, average);
    }
    @Test
    void testSetAverage(){
        book.setAverageRating(8);
        double average = book.getAverageRating();
        assertEquals(8,average);
    }
}
