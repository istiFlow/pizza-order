package com.company;

public class Pizza {
    private String name;
    private int size;
    private PizzaStatus status;

    public Pizza(String name, int size, PizzaStatus status) {
        this.name = name;
        this.size = size;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public int getDeliveryTime(){
        switch (status){
            case ORDERED:  return 30;
            case READY: return 10;
            case DELIVERED: return 0;
        }
        return 0;
    }

    public int getSmartDeliveryTime() {
    return this.status.getDeliveryTime();

    }

        @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", status=" + status + " deliveryTime " + getDeliveryTime()+ " smartDeliveryTime" + getSmartDeliveryTime() +
                '}';
    }


}
