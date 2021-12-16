package domain;

import java.util.List;

public class Order {
    private int tableNumber;
    private int menuNumber;
    private int quantity;
    private int price;
    private Category category;
    private String menuName;

    public Order(int tableNumber, int menuNumber, int quantity) {
        this.tableNumber = tableNumber;
        this.menuNumber = menuNumber;
        this.quantity = quantity;
        setPrice();
        setMenuName();
        setCategory();
    }

    private void setPrice() {
        for (Menu menu : MenuRepository.menus()) {
            if (menu.isSameMenu(menuNumber)) {
                price = menu.getPrice();
                break;
            }
        }
    }

    private void setCategory() {
        if (menuNumber == 21 || menuNumber == 22) {
            category = Category.BEVERAGE;
        }
        if (menuNumber >= 1 && menuNumber <= 6) {
            category = Category.CHICKEN;
        }
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getMenuNumber() {
        return this.menuNumber;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public int getTotalPrice() {
        return this.getPrice() * this.getQuantity();
    }

    public void setMenuName() {
        List<Menu> menus = MenuRepository.menus();

        for (Menu menu : menus) {
            if (menu.isSameMenu(this.menuNumber)) {
                menuName = menu.getName();
                break;
            }
        }
    }

    public String getOrderedList() {
        return menuName + " " + quantity + " " + price;
    }

    public boolean isChicken() {
        System.out.println(this.category);
        return this.category == Category.CHICKEN;
    }

    public boolean isSameTable(int tableNumber) {
        return this.tableNumber == tableNumber;
    }
}
