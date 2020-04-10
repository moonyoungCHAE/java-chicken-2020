import domain.PaymentMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentMethodTest {
    @DisplayName("결제 방식 생성 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void test(int paymentNumber) {
        PaymentMethod paymentMethod = PaymentMethod.of(paymentNumber);
    }

    @DisplayName("결제 방식 생성 - 예외 (존재하지 않는 결제 번호를 입력했을 때)")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void test2(int paymentNumber) {
        assertThatThrownBy(() -> PaymentMethod.of(paymentNumber))
                .hasMessageMatching("존재하지 않는 결제 방식입니다.");
    }
}
