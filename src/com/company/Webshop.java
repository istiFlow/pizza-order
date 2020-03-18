package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Webshop {
    List<Pizza> pizzas;// itt is megadhattam vna nem csak a konstruktorban

    public Webshop(){
        pizzas = new ArrayList<>();
    }

    public void orderPizza(String name, int size, PizzaStatus status){
        this.pizzas.add(new Pizza(name,size, status));
    }
    public void orderPizza(String name, int size, String status){
       //visszaadja h melyik tipusu enum
        this.pizzas.add(new Pizza(name,size, PizzaStatus.valueOf(status)));
    }

    public void work(){
        changeFistPizzaStatus(PizzaStatus.READY, PizzaStatus.DELIVERED);
        changeFistPizzaStatus(PizzaStatus.ORDERED, PizzaStatus.READY);
    }

    private void changeFistPizzaStatus(PizzaStatus source, PizzaStatus target){
        for(Pizza p : pizzas){
            if(p.getStatus() == source){
                p.setStatus(target);
                break;
            }
        }
    }
    public void print(){
        this.pizzas.stream().forEach((x)-> System.out.println(x));
    }
    public void printPizza(){
        for(Pizza p : pizzas){
            System.out.println(p);
        }
    }

    public void sortwithComparator(){
        PizzaOrderComparator pp = new PizzaOrderComparator();
        Collections.sort(this.pizzas,pp);
    }


    public void sortWithAnonymous(){
        Collections.sort(this.pizzas, new Comparator<Pizza>(){
            @Override
            public int compare(Pizza o1, Pizza o2){
                return o2.getStatus().getDeliveryTime() - o1.getStatus().getDeliveryTime();
            }
        });
    }
    public void sortWithAnonymousSize(){
        Collections.sort(this.pizzas, new Comparator<Pizza>(){
            @Override
            public int compare(Pizza o1, Pizza o2){
                return o2.getSize() - o1.getSize();
            }
        });
    }



    public void sort(){
        Collections.sort(this.pizzas, (p1, p2) -> p2.getStatus().getDeliveryTime() - p1.getStatus().getDeliveryTime());
    }
    public void sortWithSize(){
        Collections.sort(this.pizzas,(p1,p2) -> p2.getSize() - p1.getSize());
    }

    public boolean hasAnyOrderedPizza(){
        return this.pizzas.stream().anyMatch(p -> p.getStatus() == PizzaStatus.ORDERED);
    }

    public List<Pizza> getOrderedHawaiPizza(){
      return this.pizzas.stream()
                .filter(cica -> cica.getStatus() == PizzaStatus.ORDERED)
                .filter(orderPizza -> orderPizza.getName().equals("hawai"))
                .collect(Collectors.toList());
        // ha pl azt akarom h van e hawai akkor lefilterezem és utana anymatchel megnézem hogy van e benne  a 80 sor vegere .anymatch()
       // lisában adja vissza amit a streamben kiszedtunk. Addig nem alakitom listává ameddig nem csinaltam meg mindent a collectionon és a végén alakitjuk csak a .collect-el
    }

    public List<Pizza> statusAndOrdered(PizzaStatus status, String name){
        return this.pizzas.stream()
                .filter(element -> element.getStatus() == status)
                .filter(orderPizza -> orderPizza.getName().equals(name))
                .collect((Collectors.toList()));
    }

    public void getSize(){
        //Stream <Integer> sizeStream =
        this.pizzas.stream().map(pizza -> pizza.getSize()).distinct().forEach(s -> System.out.println(s));
        //System.out.println(sizeStream.collect(Collectors.toList()));
    }



}
