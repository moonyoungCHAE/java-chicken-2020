package domain.payment.discount;

public class ChickenDiscount implements Discount{
    private static final int DISCOUNT_PER_AMOUNT = 10;
    private static final int DISCOUNT_MONEY = 10_000;

    @Override
    public double discountByPercentage(double originMoney) {
        throw new UnsupportedOperationException("제공하지 않는 할인입니다.");
    }

    @Override
    public double discountByCount(double originMoney, int count) {
        int amount = count / DISCOUNT_PER_AMOUNT;
        return amount * DISCOUNT_MONEY;
    }
}
