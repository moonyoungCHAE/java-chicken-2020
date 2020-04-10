import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.payment.discount.ChickenDiscount;
import domain.payment.discount.NoDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @DisplayName("메뉴 별 총 금액 - 음료 (할인되지 않는다.)")
    @ParameterizedTest
    @CsvSource({"21,10,10000", "22,9,9000"})
    void test1(int menuNumber, int menuCount, double expected) {
        Menu menu = MenuRepository.from(menuNumber);
        Order order = new Order(menu, new NoDiscount());
        order.addMenu(menuCount);

        assertThat(order.computePrice()).isEqualTo(expected);
    }

    @DisplayName("메뉴 별 총 금액 - 10개 미만의 치킨 (할인되지 않는다.)")
    @ParameterizedTest
    @CsvSource({"1,1,16000", "2,9,144000"})
    void test2(int menuNumber, int menuCount, double expected) {
        Menu menu = MenuRepository.from(menuNumber);
        Order order = new Order(menu, new ChickenDiscount());
        order.addMenu(menuCount);

        assertThat(order.computePrice()).isEqualTo(expected);
    }

    @DisplayName("메뉴 별 총 금액 - 10개 단위의 치킨 (할인된다.)")
    @ParameterizedTest
    @CsvSource({"1,10,150000", "5,20,320000"})
    void test3(int menuNumber, int menuCount, double expected) {
        Menu menu = MenuRepository.from(menuNumber);
        Order order = new Order(menu, new ChickenDiscount());
        order.addMenu(menuCount);

        assertThat(order.computePrice()).isEqualTo(expected);
    }

    @DisplayName("메뉴 별 총 금액 확인 - 10개 이상이면서, 10단위가 아닌 치킨 (일부 할인된다.)")
    @ParameterizedTest
    @CsvSource({"1,11,166000", "6,19,313000"})
    void test4(int menuNumber, int menuCount, double expected) {
        Menu menu = MenuRepository.from(menuNumber);
        Order order = new Order(menu, new ChickenDiscount());
        order.addMenu(menuCount);

        assertThat(order.computePrice()).isEqualTo(expected);
    }
}
