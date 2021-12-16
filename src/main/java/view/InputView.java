package view;

import java.util.Scanner;

public class InputView {
    public static final String MAIN = "## 메인화면";
    public static final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_TABLE = "## 테이블을 선택하세요.";
    public static final String INPUT_MENU = "## 등록할 메뉴를 선택하세요.";
    public static final String INPUT_NUMBER = "## 메뉴의 수량을 입력하세요.";
    public static final String INPUT_PAYMENT_WAY = "## 신용 카드는 1번, 현금은 2번";

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMain() {
        System.out.println(MAIN);
        System.out.println("1 -주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }


    public static int inputFunction() {
        System.out.println(INPUT_FUNCTION);
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println(INPUT_TABLE);
        return scanner.nextInt();
    }

    public static int inputMenu() {
        System.out.println(INPUT_MENU);
        return scanner.nextInt();
    }

    public static int inputNumber() {
        System.out.println(INPUT_NUMBER);
        return scanner.nextInt();
    }

    public static int inputPaymentWay(int table) {
        System.out.println(Integer.toString(table) + "번 테이블의 결제를 진행합니다.");
        System.out.println(INPUT_PAYMENT_WAY);
        return scanner.nextInt();
    }
}
