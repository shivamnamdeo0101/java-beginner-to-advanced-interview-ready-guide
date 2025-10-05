package com.shivam.design_patterns;

interface Coffee { double cost(); String desc(); }

class SimpleCoffee implements Coffee {
    public double cost() { return 50; }
    public String desc() { return "Simple Coffee"; }
}

class Milk implements Coffee {
    Coffee c;
    Milk(Coffee c){ this.c = c; }
    public double cost() { return c.cost() + 20; }
    public String desc() { return c.desc() + ", Milk"; }
}

// ---------- Usage ----------
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new Milk(new SimpleCoffee());
        System.out.println(coffee.desc() + " → ₹" + coffee.cost());
        // Output: Simple Coffee, Milk → ₹70
    }
}

