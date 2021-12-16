import InputException.InputFunctionException;
import domain.*;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Pos {
    public static final int NUMBER_REGISTER_ORDER = 1;
    public static final int NUMBER_PAYMENT = 2;
    public static final int NUMBER_QUIT = 3;

    OrderRepository orderRepository = new OrderRepository();

    final List<Table> tables = TableRepository.tables();
    final List<Menu> menus = MenuRepository.menus();

    public boolean loopBoolean = true;
    public int functionKey;
    public int tableNumber;
    public int menuNumber;
    public int quantity;
    public int paymentWay;
    public int pay;

    public void turnOn() {
        while (true) {
            try {
                InputView.printMain();
                functionKey = InputView.inputFunction();
                InputFunctionException.checkInputFunction(functionKey);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        choiceMainMenu();
    }

    public void choiceMainMenu() {
        if (functionKey == NUMBER_REGISTER_ORDER) {
            registerOrder();
            loopBoolean = true;
        }
        if (functionKey == NUMBER_PAYMENT) {
            payment();
            loopBoolean = true;
        }
        if (functionKey == NUMBER_QUIT) {
            loopBoolean = false;
        }
    }


    public boolean getLoopBoolean() {
        return loopBoolean;
    }

    public void registerOrder() {
        choiceTable();
        choiceMenu();
        choiceQuantity();
        setOrder();
    }

    public void payment() {
        choiceTableForPayment();
        OutputView.printOrderedMenu(orderRepository.orderedMenus(), tableNumber);
        choicePaymentWay();
        calculatePayment();
        resetTable();
    }


    public void choiceTable() {
        while (true) {
            try {
                OutputView.printTables(tables);
                tableNumber = InputView.inputTableNumber();
                InputFunctionException.checkTableNumber(tableNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void choiceTableForPayment() {
        while (true) {
            try {
                OutputView.printTables(tables);
                tableNumber = InputView.inputTableNumber();
                InputFunctionException.checkTableNumber(tableNumber);
                InputFunctionException.checkOrderedTable(orderRepository, tableNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void choiceMenu() {
        while (true) {
            try {
                OutputView.printMenus(menus);
                menuNumber = InputView.inputMenu();
                InputFunctionException.checkMenu(menuNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void choiceQuantity() {
        while (true) {
            try {
                quantity = InputView.inputNumber();
                InputFunctionException.checkMaxQuantity(quantity);
                InputFunctionException.checkMinQuantity(quantity);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setOrder() {
        Order order = new Order(tableNumber, menuNumber, quantity);

        orderRepository.addOrder(order);
    }

    public void choicePaymentWay() {
        while (true) {
            try {
                paymentWay = InputView.inputPaymentWay(tableNumber);
                InputFunctionException.checkPaymentWay(paymentWay);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void calculatePayment() {
        int chickenCount = orderRepository.countChicken();
        pay = orderRepository.getTotalPayment(tableNumber);

        System.out.println(chickenCount);
        if (chickenCount >= 10) {
            pay = Discount.discountByTen(chickenCount, pay);
        }

        if (paymentWay == 2) {
            pay = Discount.discountByCash(pay);
        }

        OutputView.printTotalPayment(pay);
    }

    public void resetTable() {
        orderRepository.resetSpecificTable(tableNumber);
    }
}
