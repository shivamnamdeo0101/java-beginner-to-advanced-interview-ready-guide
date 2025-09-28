package com.shivam.java_9_multithreading;

import java.util.concurrent.*;

// ===========================================================
//      JAVA MULTITHREADING COMPLETE TUTORIAL (ONE WINDOW)
// ===========================================================

/*
🧠 WHAT is Multithreading?
   → Ability of Java to run multiple tasks (threads) concurrently.
   → A thread = smallest unit of execution.

🎯 WHY use it?
   → Better CPU utilization, responsiveness, parallelism.

📅 WHEN to use?
   → Servers, chat apps, games, animations, background tasks, large computations.

⚙️ HOW?
   → By extending Thread class OR implementing Runnable interface.
   → Or using Executor framework for better thread management.

✅ RULES / NOTES
   - Always call start(), not run() directly.
   - Use synchronization when multiple threads share resources.
   - Avoid deadlocks by acquiring locks in consistent order.
   - Thread safety = correct program execution when multiple threads access shared data.
*/

public class MultithreadingMasterDemo {

    // =======================================================
    // 1. Creating Threads (Extending Thread class)
    // =======================================================
    static class MyThread1 extends Thread {
        public void run() { System.out.println("Thread1 is running"); }
    }

    static class MyThread2 extends Thread {
        public void run() { System.out.println("Thread2 is running"); }
    }

    // =======================================================
    // 2. Creating Threads (Runnable Interface)
    // =======================================================
    static class MyRunnable implements Runnable {
        public void run() { System.out.println("Runnable Thread is running"); }
    }

    // =======================================================
    // 3. Thread Lifecycle Concept
    // =======================================================
    /*
      States of a thread: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
      start() → NEW → RUNNABLE → RUNNING
    */

    // =======================================================
    // 4. Thread Methods
    // =======================================================
    static class ThreadMethodsDemo extends Thread {
        public void run() {
            System.out.println(getName() + " running...");
            try { Thread.sleep(200); } catch (InterruptedException e) { System.out.println("Interrupted"); }
        }
    }

    // =======================================================
    // 5. Thread Priorities
    // =======================================================
    static class PriorityDemo extends Thread {
        public void run() { System.out.println(getName() + " with priority " + getPriority()); }
    }

    // =======================================================
    // 6. Synchronization
    // =======================================================
    static class Counter {
        int count = 0;
        synchronized void increment() { count++; } // ensures thread-safety
    }

    static class SyncDemo extends Thread {
        Counter c;
        SyncDemo(Counter c) { this.c = c; }
        public void run() { for (int i = 0; i < 1000; i++) c.increment(); }
    }

    // =======================================================
    // 7. Inter-thread Communication
    // =======================================================
    static class SharedResource {
        boolean flag = false;
        synchronized void produce() {
            try {
                while (flag) wait();
                System.out.println("Produced");
                flag = true;
                notify();
            } catch (Exception e) {}
        }
        synchronized void consume() {
            try {
                while (!flag) wait();
                System.out.println("Consumed");
                flag = false;
                notify();
            } catch (Exception e) {}
        }
    }

    // =======================================================
    // 8. Deadlock Example
    // =======================================================
    static class DeadlockDemo {
        static void startDeadlock() {
            final String r1 = "Resource1";
            final String r2 = "Resource2";

            Thread t1 = new Thread(() -> {
                synchronized (r1) {
                    System.out.println("T1 locked r1");
                    try { Thread.sleep(50); } catch (Exception e) {}
                    synchronized (r2) { System.out.println("T1 locked r2"); }
                }
            });

            Thread t2 = new Thread(() -> {
                synchronized (r2) {
                    System.out.println("T2 locked r2");
                    try { Thread.sleep(50); } catch (Exception e) {}
                    synchronized (r1) { System.out.println("T2 locked r1"); }
                }
            });

            t1.start(); t2.start();
        }
    }

    // =======================================================
    // 9. Concurrency Utilities (Executors, Callable, Future)
    // =======================================================
    static class ConcurrencyDemo {
        static void runExecutorDemo() throws Exception {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            Callable<Integer> task = () -> {
                Thread.sleep(100);
                return 42;
            };

            Future<Integer> future = executor.submit(task);
            System.out.println("Result from Executor: " + future.get());
            executor.shutdown();
        }

        static void runScheduledDemo() throws Exception {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            Runnable task = () -> System.out.println("Auto-saving file at " + System.currentTimeMillis());
            scheduler.scheduleAtFixedRate(task, 0, 2, java.util.concurrent.TimeUnit.SECONDS);

            Thread.sleep(5000); // run for 5s
            scheduler.shutdown();
        }
    }

    // =======================================================
    // 10. Thread Safety Demo (Volatile & Atomic)
    // =======================================================
    static class VolatileDemo {
        static volatile int a = 0, b = 0;
        static void method_one() { a++; b++; }
        static void method_two() { System.out.println("a=" + a + " b=" + b); }
    }

    static class AtomicDemo {
        static class CounterAtomic {
            java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger();
            void increment() { count.incrementAndGet(); }
        }
    }

    // =======================================================
    // MAIN METHOD
    // =======================================================
    public static void main(String[] args) throws Exception {

        System.out.println("\n=== THREAD CREATION (Thread class) ===");
        MyThread1 obj1 = new MyThread1();
        MyThread2 obj2 = new MyThread2();
        obj1.start(); obj2.start();

        System.out.println("\n=== THREAD CREATION (Runnable interface) ===");
        Thread t = new Thread(new MyRunnable());
        t.start();

        System.out.println("\n=== THREAD METHODS ===");
        ThreadMethodsDemo tm = new ThreadMethodsDemo();
        tm.setName("DemoThread");
        tm.start(); tm.join();

        System.out.println("\n=== THREAD PRIORITY ===");
        PriorityDemo p1 = new PriorityDemo();
        p1.setPriority(Thread.MAX_PRIORITY);
        p1.start();

        System.out.println("\n=== SYNCHRONIZATION ===");
        Counter c = new Counter();
        SyncDemo s1 = new SyncDemo(c); SyncDemo s2 = new SyncDemo(c);
        s1.start(); s2.start();
        s1.join(); s2.join();
        System.out.println("Final Count: " + c.count);

        System.out.println("\n=== INTER-THREAD COMMUNICATION ===");
        SharedResource resource = new SharedResource();
        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);
        producer.start(); consumer.start();
        producer.join(); consumer.join();

        System.out.println("\n=== DEADLOCK DEMO ===");
        DeadlockDemo.startDeadlock();
        Thread.sleep(200);

        System.out.println("\n=== CONCURRENCY UTILITIES ===");
        ConcurrencyDemo.runExecutorDemo();

        System.out.println("\n=== SCHEDULED EXECUTOR DEMO ===");
        ConcurrencyDemo.runScheduledDemo();

        System.out.println("\n=== REAL-WORLD APPLICATIONS ===");
        System.out.println("✔ Web servers handle multiple requests concurrently");
        System.out.println("✔ Chat apps manage many clients simultaneously");
        System.out.println("✔ Games run AI, graphics, and networking in parallel");
        System.out.println("✔ Banking systems process transactions safely");
        System.out.println("✔ Background services perform autosave, notifications");
    }
}


/*
==============================
SUMMARY
==============================
- Multithreading allows concurrent execution of tasks.
- Thread creation: Thread class, Runnable, Callable, Executor.
- Thread lifecycle: NEW → RUNNABLE → RUNNING → WAITING → TERMINATED.
- Synchronization prevents race conditions.
- wait/notify allow inter-thread communication.
- Deadlock occurs if two threads wait indefinitely for resources.
- Thread priorities influence scheduling (not guaranteed).
- Executors manage thread pools efficiently.
- ScheduledExecutorService allows periodic tasks.
- Real-world use: servers, chat apps, games, banking, background services.
==============================
*/
