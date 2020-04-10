package domain;

// 기본 생성자 추가 불가능
// 필드 변수: private
public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
