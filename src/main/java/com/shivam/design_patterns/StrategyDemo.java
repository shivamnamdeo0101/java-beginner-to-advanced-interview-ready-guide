package com.shivam.design_patterns;

interface PaymentStrategy {
    void pay(int amount);
}

class CardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
class Checkout {
    private PaymentStrategy strategy;

    Checkout(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void processPayment(int amount) {
        strategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Checkout order1 = new Checkout(new CardPayment());
        order1.processPayment(500);

        Checkout order2 = new Checkout(new UpiPayment());
        order2.processPayment(200);
    }
}




