package domain.payment.discount;

public class CashDiscount implements Discount {
    private double discountPercentage = 0.1;

    @Override
    public double discountByPercentage(double originMoney) {
        return originMoney * discountPercentage;
    }

    @Override
    public double discountByCount(double originMoney, int count) {
        throw new UnsupportedOperationException("제공하지 않는 할인입니다.");
    }
}
