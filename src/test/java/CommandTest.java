import Controller.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {
    @DisplayName("기능 선택 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test(int commadNumber) {
        Command.of(commadNumber);
    }

    @DisplayName("기능 선택 - 예외 (존재하지 않는 기능 번호)")
    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void test2(int commadNumber) {
        assertThatThrownBy(() -> Command.of(commadNumber))
                .hasMessageMatching("존재하지 않는 요청 번호입니다.");
    }
}
