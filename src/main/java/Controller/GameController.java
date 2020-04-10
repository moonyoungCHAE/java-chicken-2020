package Controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {
    private final List<Table> tables;
    private final List<Menu> menus;

    public GameController() {
        this.tables = TableRepository.tables();
        this.menus = MenuRepository.menus();
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
        table.addMenu(menu, menuCount);
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
}
