abstract class Payment {

    private String transactionId;
    private double amount;

    public Payment(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public abstract void processPayment();

    public void printReceipt() {
        System.out.println("Receipt for Transaction ID: " + transactionId + ", Amount: $" + amount);
    }
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String transactionId, double amount, String cardNumber) {
        super(transactionId, amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        String maskedCard = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Processing Credit Card Payment of $" + getAmount() + " via Card: " + maskedCard);
    }

    public void processPayment(double discountPercentage) {
        double discountedAmount = getAmount() * (1 - discountPercentage / 100);
        setAmount(discountedAmount);
        System.out.println("Discount applied (" + discountPercentage + "%). New Amount: $" + discountedAmount);
        processPayment();
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String transactionId, double amount, String upiId) {
        super(transactionId, amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI Payment of $" + getAmount() + " via UPI ID: " + upiId);
    }
}

public class OOPCorePrinciples {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating 4 Core OOP Principles ===");

        Payment payment1 = new CreditCardPayment("TXN1001", 250.00, "1234567890123456");
        Payment payment2 = new UPIPayment("TXN1002", 75.50, "user@okaxis");

        payment1.processPayment();
        payment1.printReceipt();
        System.out.println();

        CreditCardPayment ccPayment = (CreditCardPayment) payment1;
        ccPayment.processPayment(10.0);
        System.out.println();

        payment2.processPayment();
        payment2.printReceipt();
    }
}
