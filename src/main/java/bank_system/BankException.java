/**
 * Ngoại lệ chung trong hệ thống ngân hàng.
 */
package bank_system;
public class BankException extends Exception {
    public BankException(String message) {
        super(message);
    }
}
