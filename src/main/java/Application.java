import Controller.Command;
import Controller.GameController;

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
}
