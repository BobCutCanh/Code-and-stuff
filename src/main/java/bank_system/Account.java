package bank_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp trừu tượng đại diện cho một tài khoản ngân hàng.
 */
public abstract class Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public static final String CHECKING_TYPE = "CHECKING";
    public static final String SAVINGS_TYPE = "SAVINGS";

    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList;

    /**
     * Constructor khởi tạo tài khoản.
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * Thực hiện nạp tiền cơ bản.
     */
    public void doDepositing(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance += amount;
    }

    /**
     * Thực hiện rút tiền cơ bản.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount <= 0) {
            throw new InvalidFundingAmountException(amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        if (transaction != null) {
            transactionList.add(transaction);
        }
    }

    /**
     * Trả về lịch sử giao dịch.
     */
    public String getTransactionHistory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
        for (int i = 0; i < transactionList.size(); i++) {
            sb.append(transactionList.get(i).getTransactionSummary());
            if (i < transactionList.size() - 1) {
                sb.append("\n");
            }
        }
        logger.info("Đã trích xuất lịch sử cho tài khoản: {}", accountNumber);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account other = (Account) obj;
        return this.accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}