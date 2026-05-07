import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
    @Test
    void testAppGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "Greeting should not be null");
    }
}