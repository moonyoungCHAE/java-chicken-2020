package domain.payment.order;

import domain.menu.Menu;
import domain.payment.discount.Discount;

public class Order {
    private static final int MIN_MENU_COUNT = 1;
    private static final int MAX_MENU_COUNT = 99;

    private final Menu menu;
    private final Discount discount;

    private int menuCount;

    public Order(Menu menu, Discount discount) {
        this.menu = menu;
        this.menuCount = 0;
        this.discount =discount;
    }

    public void addMenu(int menuCount) {
        if (menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException("잘못된 주문 수량입니다.");
        }

        int totalMenuCount = this.menuCount + menuCount;
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("주문 가능한 최대 수량을 초과했습니다.");
        }
        this.menuCount += menuCount;
    }

    public boolean isMenu(Menu menu) {
        return this.menu == menu;
    }

    public int getMenuCount() {
        return menuCount;
    }
}
