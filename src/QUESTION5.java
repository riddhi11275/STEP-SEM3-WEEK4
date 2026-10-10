class Payment {
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    void payWithProcessingFee(double amount) {
        double total = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + total);
    }
}

public class QUESTION5 {
    static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            ((CardPayment) payment).payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
        }
    }

    static double getActualAmount(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            return amount * 1.02;
        }
        return amount;
    }

    public static void main(String[] args) {
        Payment[] payments = {
                new CardPayment(), new Payment(), new CardPayment(),
                new Payment(), new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            processTransaction(payments[i], amounts[i]);
            totalCollected += getActualAmount(payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}
