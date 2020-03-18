package com.company;

public class Main {

    public static void main(String[] args) {
        Webshop ws = new Webshop();
        ws.orderPizza("shongoku", 45, PizzaStatus.READY);
        ws.orderPizza("mogyoros", 32, PizzaStatus.DELIVERED);
        ws.orderPizza("hawai", 28, PizzaStatus.ORDERED);
        ws.orderPizza("hawai", 28, PizzaStatus.ORDERED);

        ws.print();
        ws.sortwithComparator();
        System.out.println("----------------------");
        ws.print();
        System.out.println("----------------------");
        ws.sortWithAnonymousSize();
        ws.print();
        System.out.println("----------------------");
        ws.sortWithSize();
        ws.print();
        ws.getSize();

    }
}
