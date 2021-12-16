package InputException;

import domain.*;

import java.util.List;

public class InputFunctionException {
    public static final int NUMBER_REGISTER_ORDER = 1;
    public static final int NUMBER_PAYMENT = 2;
    public static final int NUMBER_QUIT = 3;

    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 99;

    public static final int PAYMENT_CARD = 1;
    public static final int PAYMENT_CASH = 2;

    public static void checkInputFunction(int choice) {
        if (choice != NUMBER_REGISTER_ORDER && choice != NUMBER_PAYMENT && choice != NUMBER_QUIT) {
            throw new IllegalArgumentException("[ERROR] 1,2,3 중에 골라주세요.");
        }
    }

    public static void checkTableNumber(int tableNumber) {
        List<Table> tables = TableRepository.tables();

        for (Table table : tables) {
            if (table.isSameTable(tableNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당 테이블은 없습니다.");
    }

    public static void checkMenu(int menuNumber) {
        List<Menu> menus = MenuRepository.menus();

        for (Menu menu : menus) {
            if (menu.isSameMenu(menuNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당 메뉴는 없습니다.");
    }

    public static void checkMaxQuantity(int quantity) {
        if (quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 수량은 최대 99개까지 가능합니다.");
        }
    }

    public static void checkMinQuantity(int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 수량은 최소 1개 이상부터 가능합니다.");
        }
    }

    public static void checkOrderedTable(OrderRepository orderRepository, int tableNumber) {
        List<Order> orders = orderRepository.orderedMenus();

        for (Order order : orders) {
            if (order.isSameTable(tableNumber)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 주문이 없는 테이블입니다.");
    }

    public static void checkPaymentWay(int paymentWay) {
        if (paymentWay != PAYMENT_CARD && paymentWay != PAYMENT_CASH) {
            throw new IllegalArgumentException("[ERROR] 카드는 1번, 현금은 2번을 눌러주세요. (1,2번만 가능)");
        }
    }
}
