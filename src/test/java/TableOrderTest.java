import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.payment.order.TableOrder;
import domain.payment.order.TableOrderRepository;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableOrderTest {
    @DisplayName("주문 생성 확인")
    @Test
    void test() {
        final int tableNumber = 1;
        Table table = TableRepository.from(tableNumber);
        TableOrder tableOrder = TableOrderRepository.from(table);
    }


    @DisplayName("메뉴 추가 - 정상")
    @Test
    void test3() {
        final int tableNumber = 1;
        Table table = TableRepository.from(tableNumber);
        TableOrder tableOrder = new TableOrder(table);

        int menuCount = 1;
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);

        tableOrder.addMenu(menu, menuCount);
        assertThat(tableOrder.getMenuCount(menu)).isEqualTo(menuCount);
    }

    @DisplayName("메뉴 추가 - 예외 (주문 가능한 메뉴 수량을 초과했을 때)")
    @Test
    void test4() {
        Table table = TableRepository.from(1);
        TableOrder tableOrder = new TableOrder(table);
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);

        int menuCount = 99;
        tableOrder.addMenu(menu, menuCount);

        assertThatThrownBy(() -> tableOrder.addMenu(menu, 1))
                .hasMessageMatching("주문 가능한 최대 수량을 초과했습니다.");
    }

    @DisplayName("메뉴 추가 - 예외 (주문 수량이 0이하일 때)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void test7(int menuCount) {
        Table table = TableRepository.from(1);
        TableOrder tableOrder = new TableOrder(table);

        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);

        assertThatThrownBy(() -> tableOrder.addMenu(menu, menuCount))
                .hasMessageMatching("잘못된 주문 수량입니다.");
    }

    @DisplayName("주문받은 메뉴 개수 확인 - 주문되지 않은 메뉴")
    @Test
    void test6() {
        Table table = TableRepository.from(1);
        int menuCount = 1;
        int menuNumber = 1;
        Menu menu = MenuRepository.from(menuNumber);
        TableOrder tableOrder = new TableOrder(table);
        tableOrder.addMenu(menu, menuCount);

        int newMenuNumber = 2;
        Menu newMenu = MenuRepository.from(newMenuNumber);
        int expected = 0;
        assertThat(tableOrder.getMenuCount(newMenu)).isEqualTo(expected);
    }
}
