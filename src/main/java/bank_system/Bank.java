package bank_system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quản lý danh sách khách hàng và các nghiệp vụ ngân hàng.
 */
public class Bank {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Đọc danh sách khách hàng từ InputStream.
     */
    public void readCustomerList(InputStream inputStream) {
        logger.info("Bắt đầu đọc danh sách khách hàng...");
        if (inputStream == null) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Logic xử lý dữ liệu ở đây (đã rút gọn để bạn tự điền)
                logger.debug("Đang xử lý dòng: {}", line);
            }
        } catch (Exception e) {
            logger.error("Lỗi khi đọc dữ liệu khách hàng", e);
        }
    }

    /**
     * Lấy thông tin khách hàng sắp xếp theo ID.
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            sb.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Lấy thông tin khách hàng sắp xếp theo Tên.
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> sortedList = new ArrayList<>(customerList);
        sortedList.sort((c1, c2) -> {
            int nameComp = c1.getFullName().compareTo(c2.getFullName());
            return nameComp != 0 ? nameComp : Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        StringBuilder sb = new StringBuilder();
        for (Customer c : sortedList) {
            sb.append(c.getCustomerInfo()).append("\n");
        }
        return sb.toString().trim();
    }
}