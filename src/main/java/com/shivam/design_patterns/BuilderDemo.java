package com.shivam.design_patterns;

class Pizza {
    private String size;
    private boolean cheese;

    private Pizza(Builder b) {
        this.size = b.size;
        this.cheese = b.cheese;
    }

    static class Builder {
        private String size;
        private boolean cheese;

        Builder(String size) { this.size = size; } // required
        Builder cheese(boolean val) { this.cheese = val; return this; } // optional
        Pizza build() { return new Pizza(this); }
    }

    void show() { System.out.println(size + " pizza, cheese: " + cheese); }
}

// ---------- Usage ----------
public class BuilderDemo {
    public static void main(String[] args) {
        Pizza p = new Pizza.Builder("Medium").cheese(true).build();
        p.show(); // Output: Medium pizza, cheese: true
    }
}

