import domain.Table;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableTest {

    @DisplayName("테이블 생성 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 8})
    void test(int tableNumber) {
        Table table = TableRepository.from(tableNumber);
    }

    @DisplayName("테이블 생성 - 예외 (존재하지 않는 테이블 번호)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void test2(int tableNumber) {
        assertThatThrownBy(() ->TableRepository.from(tableNumber)).hasMessageMatching("존재하지 않는 테이블입니다.");
    }
}
