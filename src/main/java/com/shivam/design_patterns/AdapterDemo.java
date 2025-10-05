package com.shivam.design_patterns;

// Step 1: Existing interface (old system)
interface PaymentProcessor {
    void pay(String customer, double amount);
}

// Step 2: New external API (incompatible)
class RazorpayAPI {
    public void makePayment(String user, double money) {
        System.out.println("Payment of ₹" + money + " made by " + user + " via Razorpay");
    }
}

// Step 3: Adapter to bridge the gap
class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayAPI razorpay;

    public RazorpayAdapter(RazorpayAPI razorpay) {
        this.razorpay = razorpay;
    }

    public void pay(String customer, double amount) {
        razorpay.makePayment(customer, amount);
    }
}

// ---------- USAGE ----------
public class AdapterDemo {
    public static void main(String[] args) {
        RazorpayAPI api = new RazorpayAPI();
        PaymentProcessor processor = new RazorpayAdapter(api);
        processor.pay("Shivam", 1500.00);
    }
}

