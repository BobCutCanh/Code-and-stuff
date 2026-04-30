package bank_system;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList;

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.accountList = new ArrayList<>();
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCustomerInfo() {
        return String.format("Số CMND: %d. Họ tên: %s.", idNumber, fullName);
    }
}