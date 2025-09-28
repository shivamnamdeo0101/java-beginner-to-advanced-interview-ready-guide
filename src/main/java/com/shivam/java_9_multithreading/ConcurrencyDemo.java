package com.shivam.java_9_multithreading;

// ==========================
// JAVA CONCURRENCY METHODS
// wait(), notify(), notifyAll()
// With WHAT, WHY, WHEN, HOW, RULES, PROS, CONS, Example + Output
// ==========================

// 1. WHAT
/*
- wait(): Makes the current thread wait until another thread calls notify() or notifyAll() on the same object.
- notify(): Wakes up one waiting thread on the object's monitor.
- notifyAll(): Wakes up all waiting threads on the object's monitor.
All three are defined in the Object class.
*/

// 2. WHY
/*
- To allow proper communication between threads sharing the same resource.
- Solves synchronization problems like Producer-Consumer, avoiding busy-waiting.
*/

// 3. WHEN
/*
- When one thread depends on a condition that another thread must satisfy.
- Example: Consumer waits for Producer to produce data.
*/

// 4. HOW
/*
- Must be called inside synchronized blocks/methods.
- wait() releases the lock until notified.
- notify()/notifyAll() do not release the lock immediately; lock released when synchronized block ends.
*/

// 5. RULES / NOTES
/*
- Only callable inside synchronized context.
- Otherwise, throws IllegalMonitorStateException.
- wait() releases lock temporarily.
- notify() wakes one waiting thread; notifyAll() wakes all waiting threads.
- Always use while loops to check conditions before calling wait() to avoid spurious wakeups.
*/

// 6. PROS
/*
- Provides clean inter-thread communication.
- Solves common problems like Producer-Consumer.
- Prevents CPU-intensive busy waiting.
*/

// 7. CONS
/*
- Risk of deadlocks if misused.
- Harder to debug.
- Only works with synchronized blocks, not standalone.
*/

// ==========================
// EXAMPLE: PRODUCER-CONSUMER USING wait(), notify()
// ==========================
class SharedResource {
    private int data;
    private boolean hasData = false;

    // Consumer waits until data is available
    public synchronized void consume() {
        try {
            while (!hasData) {           // Check condition before waiting
                wait();                  // Wait releases the lock
            }
            System.out.println("Consumed: " + data);
            hasData = false;
            notify();                    // Notify producer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Producer waits until consumer consumes data
    public synchronized void produce(int value) {
        try {
            while (hasData) {            // Check if data already exists
                wait();                  // Wait releases the lock
            }
            data = value;
            hasData = true;
            System.out.println("Produced: " + data);
            notify();                    // Notify consumer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConcurrencyDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.produce(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                resource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}

/*
EXPECTED OUTPUT:
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
*/

/*
==========================
SUMMARY
==========================

SharedResource (monitor)
+--------------------+
| hasData = false    |
| data               |
+--------------------+
Producer waits?   Consumer waits?
    |                 |
    |  produce()       | consume()
    |----------------->|
    |  notify()         | notify()

- wait(): Makes a thread wait & releases lock.
- notify(): Wakes up one waiting thread.
- notifyAll(): Wakes up all waiting threads.
- Use in synchronized blocks to allow thread communication.
- Ideal for problems like Producer-Consumer, task coordination.
- Always check condition in a loop before wait() to avoid spurious wakeups.
- Pros: Clean communication, avoids busy-waiting.
- Cons: Risk of deadlocks, harder to debug.
*/

