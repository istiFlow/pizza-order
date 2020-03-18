package com.company;

public enum PizzaStatus {

    ORDERED(30) {
        @Override
        public void printHello(){
            System.out.println("hohoho");
        }
    },
    READY(10),
    DELIVERED(0);

    private int deliveryTime;

   PizzaStatus(int deliveryTime) {
        this.deliveryTime = deliveryTime;
   }

   public int getDeliveryTime(){
       return deliveryTime;
   }

   public void printHello(){
       System.out.println("Hellooo");
   }

}

