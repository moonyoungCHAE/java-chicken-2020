package domain.payment;

import domain.payment.discount.CashDiscount;
import domain.payment.discount.Discount;
import domain.payment.discount.NoDiscount;

public class Payment {
    private final double totalPrice;
    private final Discount discount;

    public Payment(double totalPrice,  PaymentMethod paymentMethod) {
        this.totalPrice = totalPrice;
        Discount discount = new NoDiscount();
        if (paymentMethod == PaymentMethod.CASH) {
            discount = new CashDiscount();
        }
        this.discount = discount;
    }

    public double computePrice() {
        return this.totalPrice - discount.discountByPercentage(totalPrice);
    }
}
