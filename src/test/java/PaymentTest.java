import domain.payment.Payment;
import domain.payment.PaymentMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    @DisplayName("현금 결제")
    @ParameterizedTest
    @CsvSource({"10000,9500"})
    void test1(double price, double expected) {
        Payment payment = new Payment(price, PaymentMethod.CASH);
        assertThat(payment.computePrice()).isEqualTo(expected);
    }

    @DisplayName("카드 결제")
    @ParameterizedTest
    @CsvSource({"10000,10000"})
    void test2(double price, double expected) {
        Payment payment = new Payment(price, PaymentMethod.CARD);
        assertThat(payment.computePrice()).isEqualTo(expected);
    }
}
