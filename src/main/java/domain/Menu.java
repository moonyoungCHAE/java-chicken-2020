package domain;

// 기본 생성자 추가 불가능
// 인스턴스 변수 추가 불가능
// 인스턴스 변수 데이터 타입은 변경 가능
// 필드의 접근 제어자 : private
public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public int getNumber() {
        return number;
    }
}
