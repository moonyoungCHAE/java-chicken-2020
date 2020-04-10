package domain.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.payment.discount.ChickenDiscount;
import domain.payment.discount.Discount;
import domain.payment.discount.NoDiscount;
import domain.table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TableOrder {
    private final Table table;
    private final List<Order> orders;

    public TableOrder(Table table) {
        Objects.requireNonNull(table);
        this.table = table;
        this.orders = createOrders();
    }

    private List<Order> createOrders() {
        List<Order> orders = new ArrayList<>();
        for (Menu menu : MenuRepository.menus()) {
            Discount discount = new NoDiscount();
            if (menu.isChicken()) {
                discount = new ChickenDiscount();
            }
            orders.add(new Order(menu, discount));
        }
        return orders;
    }

    public boolean isOwnerOf(Table table) {
        return this.table == table;
    }

    public void addMenu(Menu menu, int menuCount) {
        findOrder(menu).addMenu(menuCount);
    }

    private Order findOrder(Menu menu) {
        Order result = orders.stream()
                .filter(order -> order.isMenu(menu))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("처리할 수 없는 메뉴입니다."));
        return result;
    }

    public int getMenuCount(Menu menu) {
        return findOrder(menu).getMenuCount();
    }
}
