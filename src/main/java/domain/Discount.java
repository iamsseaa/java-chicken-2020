package domain;

public class Discount {

    public static int discountByTen(int totalChicken, int pay) {
        int discount = Math.floorDiv(totalChicken,10) * 10000;
        System.out.println(discount);

        return pay - discount;
    }

    public static int discountByCash(int pay) {
        return (int) (pay - (pay * 0.05));
    }
}
