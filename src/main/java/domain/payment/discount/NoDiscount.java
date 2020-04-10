package domain.payment.discount;

public class NoDiscount implements Discount {
    @Override
    public double discountByPercentage(double originMoney) {
        return 0;
    }

    @Override
    public double discountByCount(double originMoney, int count) {
        return 0;
    }
}
