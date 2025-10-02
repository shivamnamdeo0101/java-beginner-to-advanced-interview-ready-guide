package com.shivam.java_13_synchronization;

/*
=====================================================
  JAVA SYNCHRONIZATION – SIMPLE WH FAMILY NOTES
=====================================================
*/

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {

        /* ===========================================
           1. SYNCHRONIZED METHOD
           =========================================== */
        System.out.println("===== 1. SYNCHRONIZED METHOD =====");

        /*
        WHAT: Method-level lock to allow only one thread at a time.
        WHY: Prevents data inconsistency when multiple threads modify shared data.
        WHEN: Use when a method modifies shared resources.
        HOW: Add 'synchronized' keyword to method declaration.
        RULES: Only one thread can enter synchronized method per object instance.
        PROS: Simple, easy to implement.
        CONS: Can slow performance if overused.
        */

        class Counter {
            private int count = 0;
            public synchronized void increment() {
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented: " + count);
            }
            public int getCount() { return count; }
        }

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> counter.increment(), "Thread1");
        Thread t2 = new Thread(() -> counter.increment(), "Thread2");
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Final Count: " + counter.getCount());


        /* ===========================================
           2. SYNCHRONIZED BLOCK
           =========================================== */
        System.out.println("\n===== 2. SYNCHRONIZED BLOCK =====");

        /*
        WHAT: Block-level synchronization for fine-grained locking.
        WHY: Limits lock scope to only critical section, improving performance.
        WHEN: Use when only part of method needs protection.
        HOW: Wrap code in 'synchronized(object) { ... }'.
        */

        class BlockCounter {
            private int count = 0;
            private Object lock = new Object();
            public void increment() {
                synchronized (lock) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + " block incremented: " + count);
                }
            }
            public int getCount() { return count; }
        }

        BlockCounter bCounter = new BlockCounter();
        Thread t3 = new Thread(() -> bCounter.increment(), "Thread3");
        Thread t4 = new Thread(() -> bCounter.increment(), "Thread4");
        t3.start(); t4.start();
        t3.join(); t4.join();


        /* ===========================================
           3. ATOMIC VARIABLE
           =========================================== */
        System.out.println("\n===== 3. ATOMIC VARIABLE =====");

        /*
        WHAT: Atomic classes like AtomicInteger provide thread-safe operations.
        WHY: Simple alternative to synchronized for counters.
        WHEN: Use for numeric counters or single-value updates.
        HOW: Use methods like incrementAndGet(), getAndSet().
        PROS: Fast, no explicit locks.
        */

        AtomicInteger atomicCounter = new AtomicInteger(0);
        Thread t5 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " atomic increment: " + atomicCounter.incrementAndGet()), "Thread5");
        Thread t6 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " atomic increment: " + atomicCounter.incrementAndGet()), "Thread6");
        t5.start(); t6.start();
        t5.join(); t6.join();


        /* ===========================================
           4. REENTRANT LOCK
           =========================================== */
        System.out.println("\n===== 4. REENTRANT LOCK =====");

        /*
        WHAT: Explicit lock object for advanced synchronization.
        WHY: More flexible than 'synchronized', supports tryLock(), fairness.
        WHEN: Use when fine-grained control or multiple methods need same lock.
        HOW: Create ReentrantLock, call lock() before critical section, unlock() after.
        PROS: Advanced features, flexible.
        CONS: Must unlock manually to avoid deadlock.
        */

        ReentrantLock lock = new ReentrantLock();
        class LockCounter {
            private int count = 0;
            public void increment() {
                lock.lock();
                try {
                    count++;
                    System.out.println(Thread.currentThread().getName() + " lock incremented: " + count);
                } finally {
                    lock.unlock();
                }
            }
        }

        LockCounter lCounter = new LockCounter();
        Thread t7 = new Thread(() -> lCounter.increment(), "Thread7");
        Thread t8 = new Thread(() -> lCounter.increment(), "Thread8");
        t7.start(); t8.start();
        t7.join(); t8.join();


        /* ===========================================
           5. DEADLOCK EXAMPLE (simplified)
           =========================================== */
        System.out.println("\n===== 5. DEADLOCK SIMPLIFIED =====");

        /*
        WHAT: Deadlock occurs when two threads wait on each other’s lock forever.
        WHY: Demonstrates need for careful lock order.
        WHEN: Multiple locks acquired by multiple threads.
        HOW: Avoid by consistent lock ordering or tryLock().
        */

        final Object res1 = new Object();
        final Object res2 = new Object();

        Thread dead1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("Dead1 locked res1");
                try { Thread.sleep(50); } catch(Exception e){}
                synchronized (res2) {
                    System.out.println("Dead1 locked res2");
                }
            }
        });

        Thread dead2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println("Dead2 locked res2");
                try { Thread.sleep(50); } catch(Exception e){}
                synchronized (res1) {
                    System.out.println("Dead2 locked res1");
                }
            }
        });

        dead1.start();
        dead2.start();
        dead1.join();
        dead2.join();

        System.out.println("Finished all examples.");
    }
}


