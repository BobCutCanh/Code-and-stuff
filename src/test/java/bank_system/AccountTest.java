package bank_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Các bài kiểm thử đơn vị cho lớp Account (CheckingAccount).
 */
public class AccountTest {

    private CheckingAccount account;

    @BeforeEach
    void setUp() {
        // Khởi tạo một tài khoản mới trước mỗi bài test
        account = new CheckingAccount(123456789L, 1000.0);
    }

    @Test
    @DisplayName("Kiểm tra nạp tiền hợp lệ")
    void testDepositSuccess() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Số dư phải là 1500 sau khi nạp 500");
    }

    @Test
    @DisplayName("Kiểm tra rút tiền hợp lệ")
    void testWithdrawSuccess() {
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance(), "Số dư phải còn 600 sau khi rút 400");
    }

    @Test
    @DisplayName("Kiểm tra lỗi khi nạp số tiền âm")
    void testDepositNegativeAmount() {
        // Với mã nguồn đã refactor, hàm doDepositing sẽ ném ngoại lệ
        assertThrows(InvalidFundingAmountException.class, () -> {
            account.doDepositing(-100.0);
        }, "Phải ném InvalidFundingAmountException khi nạp tiền âm");
    }

    @Test
    @DisplayName("Kiểm tra lỗi khi rút quá số dư")
    void testWithdrawOverBalance() {
        assertThrows(InsufficientFundsException.class, () -> {
            account.doWithdrawing(2000.0);
        }, "Phải ném InsufficientFundsException khi rút quá số dư");
    }

    @Test
    @DisplayName("Kiểm tra ghi nhận lịch sử giao dịch")
    void testTransactionHistoryCount() {
        account.deposit(200.0);
        account.withdraw(100.0);
        assertEquals(2, account.getTransactionList().size(), "Phải có 2 giao dịch trong danh sách");
    }
}