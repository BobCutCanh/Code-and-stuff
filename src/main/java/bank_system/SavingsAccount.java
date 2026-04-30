package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản tiết kiệm với các quy định riêng.
 */
public class SavingsAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
    public static final double MAX_WITHDRAW = 1000.0;
    public static final double MIN_BALANCE = 5000.0;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        try {
            double initialBalance = getBalance();
            doDepositing(amount);
            Transaction t = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
                    amount, initialBalance, getBalance());
            addTransaction(t);
            logger.info("Nạp tiền tiết kiệm thành công: {}", amount);
        } catch (BankException e) {
            logger.error("Lỗi nạp tiền: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > MAX_WITHDRAW || (getBalance() - amount) < MIN_BALANCE) {
                throw new BankException("Giao dịch không hợp lệ cho tài khoản tiết kiệm");
            }
            double initialBalance = getBalance();
            doWithdrawing(amount);
            Transaction t = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
                    amount, initialBalance, getBalance());
            addTransaction(t);
        } catch (BankException e) {
            logger.warn("Rút tiền tiết kiệm thất bại: {}", e.getMessage());
        }
    }
}