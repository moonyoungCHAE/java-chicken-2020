import Controller.GameController;
import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Command command = null;
        do {
            try {
                command = gameController.play();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        } while(command != Command.END);
    }

    public static void addOrder() {

    }
}
