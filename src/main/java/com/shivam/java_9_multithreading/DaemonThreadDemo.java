package com.shivam.java_9_multithreading;
// ===========================================================
//        JAVA DAEMON THREAD COMPLETE DEMO (ONE WINDOW)
// ===========================================================

/*
🧠 WHAT is a Daemon Thread?
   → Low-priority background thread in Java.
   → Provides services to user threads (e.g., garbage collection).
   → JVM automatically terminates daemon threads when all user threads finish.

🎯 WHY use it?
   → To perform background tasks without blocking main execution.
   automatic resource cleanup.

📅 WHEN to use?
   → Background monitoring, logging, housekeeping, garbage collection.

⚙️ PROPERTIES
   1. Cannot prevent JVM exit.
   2. Low priority.
   3. Inherits daemon status from parent thread.
   4. JVM terminates daemon threads automatically when no user threads remain.

Feature	    User Thread (Default)	                                               | Daemon Thread
Purpose	    Executes the application's core logic and essential tasks.	           | Provides background services to user threads (e.g., monitoring, housekeeping).
JVM Exit	Prevents the JVM from exiting.	Does not prevent the JVM from exiting; | it terminates when all user threads are done.
Priority	Generally higher priority/importance for application function.	       | Generally low priority.
*/

// =======================================================
// 1. Basic Daemon Thread Example
// =======================================================
class DaemonThreadBasic extends Thread {
    @Override
    public void run() {
        System.out.println("Running the Daemon Thread");
    }
}

// =======================================================
// 2. Using setDaemon() and isDaemon()
// =======================================================
class DaemonThreadCheck extends Thread {
    public DaemonThreadCheck(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println(getName() + " is Daemon thread");
        } else {
            System.out.println(getName() + " is User thread");
        }
    }
}

// =======================================================
// 3. Handling JVM Exit Issue
// =======================================================
class DaemonThreadSleep extends Thread {
    @Override
    public void run() {
        System.out.println("Running the Daemon Thread after sleep");
    }
}

// =======================================================
// 4. Exception Case: setDaemon() after start()
// =======================================================
class DaemonThreadException extends Thread {
    public DaemonThreadException(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        System.out.println("Check if DaemonThread: " + Thread.currentThread().isDaemon());
    }
}

// =======================================================
// MAIN DEMO CLASS
// =======================================================
public class DaemonThreadDemo {
    public static void main(String[] args) {

        System.out.println("\n=== BASIC DAEMON THREAD ===");
        DaemonThreadBasic t1 = new DaemonThreadBasic();
        t1.setDaemon(true); // mark as daemon
        t1.start();
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n=== CHECK DAEMON STATUS ===");
        DaemonThreadCheck d1 = new DaemonThreadCheck("Thread-1");
        DaemonThreadCheck d2 = new DaemonThreadCheck("Thread-2");
        DaemonThreadCheck d3 = new DaemonThreadCheck("Thread-3");
        d1.setDaemon(true); // set as daemon
        d1.start();
        d2.start();
        d3.setDaemon(true);
        d3.start();

        try { d1.join(); d2.join(); d3.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n=== JVM EXIT ISSUE FIX WITH SLEEP ===");
        DaemonThreadSleep t2 = new DaemonThreadSleep();
        t2.setDaemon(true);
        t2.start();
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\n=== EXCEPTION CASE: setDaemon() AFTER start() ===");
        DaemonThreadException dtEx1 = new DaemonThreadException("t1");
        DaemonThreadException dtEx2 = new DaemonThreadException("t2");

        try {
            dtEx1.start();
            dtEx1.setDaemon(true); // throws IllegalThreadStateException
            dtEx2.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Illegal Thread State Exception Thrown");
        }

        System.out.println("\n=== DEMO COMPLETE ===");
    }
}

/*
==============================
SUMMARY
==============================
- Daemon threads run in the background, supporting user threads.
- JVM automatically terminates them when no user threads remain.
- Use setDaemon(true) before start(), otherwise IllegalThreadStateException occurs.
- Sleep or join main thread to ensure daemon threads get executed.
- Typical use: Garbage collection, logging, background monitoring.
==============================
*/
