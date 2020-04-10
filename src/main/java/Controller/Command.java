package Controller;

import java.util.Arrays;

public enum Command {
    ORDER(1, "주문 등록"),
    PAYMENT(2, "결제하기"),
    END(3, "프로그램 종료");

    private final int commandNumber;
    private final String name;

    Command(int commandNumber, String name) {
        this.commandNumber = commandNumber;
        this.name = name;
    }

    public static Command of(int commandNumber) {
        return Arrays.stream(Command.values())
                .filter(command -> command.getCommandNumber() == commandNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 요청 번호입니다."));
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public String getName() {
        return name;
    }
}
