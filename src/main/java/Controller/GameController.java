package Controller;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.payment.order.TableOrder;
import domain.payment.order.TableOrderRepository;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    private final List<Table> tables;
    private final List<Menu> menus;
    private final List<TableOrder> tableOrders;

    public GameController() {
        this.tables = TableRepository.tables();
        this.menus = MenuRepository.menus();
        this.tableOrders = TableOrderRepository.tableOrders();
    }

    public Command play() {
            OutputView.printMain();
            Command command = InputView.inputCommand();
            if (command == Command.ORDER) {
                addOrder();
            }
            if (command == Command.PAYMENT) {
                pay();
            }
            return command;
    }


    private void addOrder() {
        Table table = selectTable();
        Menu menu = selectMenu();
        final int menuCount = InputView.inputMenuCount();
        findTableOrder(table).addMenu(menu, menuCount);
    }

    private void pay() {
        selectMenu();
    }

    private Table selectTable () {
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        return TableRepository.from(tableNumber);
    }

    private Menu selectMenu () {
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        return MenuRepository.from(menuNumber);
    }

    private TableOrder findTableOrder(Table table) {
        TableOrder result = tableOrders.stream()
                .filter(tableOrder -> tableOrder.isOwnerOf(table))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("처리할 수 없는 테이블입니다."));
        return result;
    }
}
