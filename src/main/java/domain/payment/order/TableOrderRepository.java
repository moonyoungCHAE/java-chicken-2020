package domain.payment.order;

import domain.table.Table;
import domain.table.TableRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TableOrderRepository {
    private static final List<TableOrder> TABLE_ORDERS = new ArrayList<>();

    static {
        for (Table table : TableRepository.tables()) {
            TABLE_ORDERS.add(new TableOrder(table));
        }
    }

    public static List<TableOrder> tableOrders() {
        return Collections.unmodifiableList(TABLE_ORDERS);
    }

    public static TableOrder from(Table table) {
        Objects.requireNonNull(table);

        for (TableOrder order : TABLE_ORDERS) {
            if (order.isOwnerOf(table)) {
                return order;
            }
        }
        throw  new IllegalArgumentException("존재하지 않는 테이블입니다.");
    }
}
