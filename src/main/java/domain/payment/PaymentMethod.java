package domain.payment;

import java.util.Arrays;

public enum  PaymentMethod {
    CARD(1),
    CASH(2);

    private final int paymentNumber;

    PaymentMethod(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public static PaymentMethod of(int paymentNumber) {
        return Arrays.stream(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.getPaymentNumber() == paymentNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제 방식입니다."));
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }
}
