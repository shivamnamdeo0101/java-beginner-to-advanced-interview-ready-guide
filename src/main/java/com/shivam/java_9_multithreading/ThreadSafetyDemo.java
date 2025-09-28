package com.shivam.java_9_multithreading;
import java.util.concurrent.atomic.AtomicInteger;

// ===========================================================
//        JAVA THREAD SAFETY COMPLETE DEMO (ONE WINDOW)
// ===========================================================

/*
🧠 WHAT is Thread Safety?
   → When multiple threads access the same object or code concurrently,
     the program behaves correctly without data corruption.
   → Thread-safe classes/methods work correctly even under concurrent access.

🎯 WHY important?
   → Prevents race conditions, data inconsistency, and unexpected behavior.

📅 WHEN to use?
   → Any multi-threaded environment: servers, background tasks, concurrent processing.

✅ FOUR WAYS TO ACHIEVE THREAD SAFETY
   1. Synchronization
   2. Volatile Keyword
   3. Atomic Variables
   4. Immutable Objects
*/

// =======================================================
// 1. Using Synchronization
// =======================================================
class A {
    synchronized void sum(int n) {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(t.getName() + " : " + (n + i));
        }
    }
}

class B extends Thread {
    A a = new A();
    public void run() {
        a.sum(10);
    }
}

// =======================================================
// 2. Using Volatile Keyword
// =======================================================
class VolatileDemo {
    static volatile int a = 0, b = 0;

    static void method_one() { a++; b++; }
    static void method_two() { System.out.println("a=" + a + " b=" + b); }
}

// =======================================================
// 3. Using Atomic Variables
// =======================================================

class Counter {
    AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }
}

class AtomicDemo {
    public static void runDemo() throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Count (Atomic): " + c.count);
    }
}

// =======================================================
// 4. Using Immutable Objects
// =======================================================
final class Student {
    private final String name;
    private final int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
}

// =======================================================
// MAIN CLASS TO DEMONSTRATE ALL
// =======================================================
public class ThreadSafetyDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n=== SYNCHRONIZATION DEMO ===");
        B b = new B();
        Thread t1 = new Thread(b); t1.setName("Thread A");
        Thread t2 = new Thread(b); t2.setName("Thread B");
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("\n=== VOLATILE KEYWORD DEMO ===");
        Thread v1 = new Thread(() -> { for (int i = 0; i < 5; i++) VolatileDemo.method_one(); });
        Thread v2 = new Thread(() -> { for (int i = 0; i < 5; i++) VolatileDemo.method_two(); });
        v1.start(); v2.start();
        v1.join(); v2.join();

        System.out.println("\n=== ATOMIC VARIABLE DEMO ===");
        AtomicDemo.runDemo();

        System.out.println("\n=== IMMUTABLE OBJECT DEMO ===");
        Student s = new Student("Shivam", 101);
        System.out.println("Student Name: " + s.getName() + ", Roll No: " + s.getRollNo());

        System.out.println("\n=== THREAD SAFETY VS NON-THREAD SAFETY ===");
        System.out.println("Thread-Safe: Vector, Hashtable, ConcurrentHashMap, StringBuffer");
        System.out.println("Non-Thread-Safe: ArrayList, HashMap, StringBuilder, SimpleDateFormat");
    }
}

/*
==============================
SUMMARY
==============================
- Thread Safety ensures correct behavior under concurrent access.
- Synchronization locks critical sections to prevent race conditions.
- Volatile ensures visibility of variable changes across threads.
- Atomic variables allow thread-safe updates without locking.
- Immutable objects are inherently thread-safe.
- Always prefer thread-safe classes in multi-threaded environments.
==============================
*/
