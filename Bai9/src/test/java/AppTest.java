import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    // Khai báo logger cho class Test
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void testLoggingFormat() {
        logger.info("Đang chạy Unit Test để kiểm tra định dạng log...");

        try {
            // Giả lập một hành động kiểm thử
            boolean isServerUp = true;

            if (isServerUp) {
                logger.info("Trạng thái hệ thống: {}", "HOẠT ĐỘNG");
                assertTrue(isServerUp);
            }
        } catch (Exception e) {
            logger.error("Lỗi xảy ra trong quá trình Test: {}", e.getMessage());
        }

        logger.info("Kết thúc Unit Test thành công.");
    }
}