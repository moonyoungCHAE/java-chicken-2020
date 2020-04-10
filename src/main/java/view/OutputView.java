package view;

import Controller.Command;
import domain.menu.Menu;
import domain.order.Order;
import domain.order.TableOrder;
import domain.payment.Payment;
import domain.table.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String NEW_LINE = System.lineSeparator();

    public static void printMain() {
        System.out.println("## 메인화면");
        StringBuilder stringBuilder = new StringBuilder();
        for (Command command : Command.values()) {
            stringBuilder.append(command.getCommandNumber());
            stringBuilder.append("-");
            stringBuilder.append(command.getName());
            stringBuilder.append(NEW_LINE);
        }
        System.out.println(stringBuilder);
        System.out.println();
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrder(TableOrder tableOrder) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");

        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : tableOrder.getOrders()) {
            Menu menu = order.getMenu();
            stringBuilder.append(menu.getName());
            stringBuilder.append(order.getMenuCount());
            stringBuilder.append(order.computePrice());
            stringBuilder.append(NEW_LINE);
        }
        System.out.println(stringBuilder);
        System.out.println();
    }

    public static void printPrice(Payment payment) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(payment.computePrice()+"원");
    }
}
