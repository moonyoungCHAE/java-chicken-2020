package domain.table;

import domain.menu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 기본 생성자 추가 불가능
// 필드 변수: private
public class Table {
    private static final int MAX_MENU_COUNT = 99;
    private static final int MIN_MENU_COUNT = 1;

    private final int number;
    private final Map<Menu, Integer> menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new HashMap<>();
    }

    public void addMenu(Menu menu, int menuCount) {
        Objects.requireNonNull(menu);
        if (menuCount < MIN_MENU_COUNT) {
            throw new IllegalArgumentException("잘못된 주문 수량입니다.");
        }

        int totalMenuCount = getMenuCount(menu)+ menuCount;
        if (totalMenuCount > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("주문 가능한 최대 수량을 초과했습니다.");
        }
        menus.put(menu, totalMenuCount);
    }

    public int getMenuCount(Menu menu) {
        Objects.requireNonNull(menu);
        return menus.getOrDefault(menu, 0);
    }

    public Map<Menu, Integer> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
