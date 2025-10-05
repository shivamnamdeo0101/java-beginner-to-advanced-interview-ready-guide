
//Facade , Singleton, Strategy , Factory
package com.shivam.design_patterns;

class InventoryService{
    void checkStock(String item){
        System.out.println("Checking item "+item );
    }
}

class OrderService{
    void createOrder(String item){
        System.out.println("Making an order for this "+ item);
    }
}

class PaymentService{
    void pay(String item){
        System.out.println("Payment done for item "+item);
    }
}

class CheckoutService{
    private PaymentService payment = new PaymentService();
    private OrderService order = new OrderService();
    private InventoryService inventory = new InventoryService();

    void checkout(String item){
        inventory.checkStock(item);
        order.createOrder(item);
        payment.pay(item);
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();
        checkout.checkout("Shoes");
        checkout.checkout("Bag");

    }
}
