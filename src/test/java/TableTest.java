import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("테이블에 메뉴 추가 - 정상")
    @Test
    void test3() {
        Table table = new Table(1);
        int menuCount = 1;
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);
        table.addMenu(menu, menuCount);
        assertThat(table.getMenuCount(menu)).isEqualTo(menuCount);
    }

    @DisplayName("테이블에 메뉴 추가 - 예외 (주문 가능한 메뉴 수량을 초과했을 때)")
    @Test
    void test4() {
        Table table = new Table(1);
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);

        int menuCount = 99;
        table.addMenu(menu, menuCount);

        assertThatThrownBy(() -> table.addMenu(menu, 1))
                .hasMessageMatching("주문 가능한 최대 수량을 초과했습니다.");
    }

    @DisplayName("테이블에 메뉴 추가 - 예외 (주문 수량이 0이하일 때)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void test7(int menuCount) {
        Table table = new Table(1);
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);
        assertThatThrownBy(() -> table.addMenu(menu, menuCount))
                .hasMessageMatching("잘못된 주문 수량입니다.");
    }

    @DisplayName("테이블에 존재하는 메뉴 개수 확인 - 추가되지 않은 메뉴")
    @Test
    void test6() {
        Table table = new Table(1);
        int menuCount = 1;
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);
        table.addMenu(menu, menuCount);

        int newMenuNumber = 2;
        Menu newMenu = MenuRepository.from(newMenuNumber);
        int expected = 0;
        assertThat(table.getMenuCount(newMenu)).isEqualTo(expected);
    }
}
