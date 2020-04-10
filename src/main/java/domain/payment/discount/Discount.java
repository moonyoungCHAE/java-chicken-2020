package domain.payment.discount;

public interface Discount {
    double discountByPercentage(double originMoney);
    double discountByCount(double originMoney, int count);
}
