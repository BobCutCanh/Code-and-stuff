package bank_system;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Đại diện cho một giao dịch ngân hàng.
 */
public class Transaction {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor khởi tạo giao dịch.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    private String getTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING: return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING: return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS: return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS: return "Rút tiền tiết kiệm";
            default: return "Không rõ";
        }
    }

    /**
     * Trả về tóm tắt giao dịch với dòng không quá 100 ký tự.
     */
    public String getTransactionSummary() {
        logger.debug("Đang tạo summary cho giao dịch loại: {}", type);
        String typeStr = getTypeString(type);
        String initStr = String.format(Locale.US, "%.2f", initialBalance);
        String amtStr = String.format(Locale.US, "%.2f", amount);
        String finalStr = String.format(Locale.US, "%.2f", finalBalance);

        return String.format("- Kiểu giao dịch: %s. Số dư ban đầu: $%s. "
                + "Số tiền: $%s. Số dư cuối: $%s.", typeStr, initStr, amtStr, finalStr);
    }
}