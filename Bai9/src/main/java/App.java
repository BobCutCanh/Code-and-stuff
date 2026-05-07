import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    // Khai báo Logger theo đúng class hiện tại
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String studentName = "Người học";
        String lesson = "Bài 9: Logging chuyên nghiệp";

        // Yêu cầu 1 & 3: Thay System.out bằng Parameterized Logging (dùng {})
        logger.info("Chào mừng {}, bạn đang thực hiện: {}", studentName, lesson);

        try {
            logger.info("Đang bắt đầu quá trình xử lý dữ liệu...");

            // Giả lập một lỗi chia cho 0 để kiểm tra log ERROR
            int calculation = 10 / 0;

        } catch (Exception e) {
            // Yêu cầu 2: Sử dụng mức ERROR để xử lý ngoại lệ
            logger.error("Đã xảy ra lỗi hệ thống: {}", e.getMessage());
        }

        logger.info("Hoàn thành bài kiểm tra Logging.");
    }
}