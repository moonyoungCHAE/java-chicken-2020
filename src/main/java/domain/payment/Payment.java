package domain.payment;

import domain.order.TableOrder;
import domain.payment.discount.Discount;

public class Payment {
    private final TableOrder tableOrder;
    private final Discount discount;

    public Payment(TableOrder tableOrder, Discount discount) {
        this.tableOrder = tableOrder;
        this.discount = discount;
    }
}
