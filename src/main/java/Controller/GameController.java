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
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        final Table table = TableRepository.from(tableNumber);

        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final Menu menu = MenuRepository.from(menuNumber);

        final int menuCount = InputView.inputMenuCount();
        table.addMenu(menu, menuCount);
    }

    private void pay() {

    }
}
