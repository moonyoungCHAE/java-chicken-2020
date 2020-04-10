import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {
    @DisplayName("메뉴 생성 - 정상")
    @ParameterizedTest
    @ValueSource(ints = {1, 6, 21, 22})
    void test(int menuNumber) {
        Menu menu = MenuRepository.from(menuNumber);
    }

    @DisplayName("메뉴 생성 - 예외 (존재하지 않는 메뉴 번호)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 20, 23})
    void test2(int menuNumber) {
        assertThatThrownBy(() ->MenuRepository.from(menuNumber)).hasMessageMatching("존재하지 않는 메뉴입니다.");
    }
}
