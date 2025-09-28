package com.shivam.java_9_multithreading;
// ===========================================================
//      JAVA THREAD POOL COMPLETE DEMO (ONE WINDOW)
// ===========================================================

/*
🧠 WHAT is Thread Pool?
   → A collection of pre-created, reusable threads.
   → Avoids creating a new thread for every task.
   → Threads pick tasks from a queue and remain alive after completion.

🎯 WHY use it?
   → Better performance, faster response, reusability, and resource management.

📅 WHEN to use?
   → Servers handling multiple requests, background tasks, periodic jobs, large computations.

📍 REAL WORLD ANALOGY
   → Call center with fixed number of operators handling incoming calls.
   → If all operators are busy, new calls wait in queue.
   → Operators stay active and handle more calls after finishing.

✅ RULES / NOTES
   - Always reuse threads instead of creating new ones repeatedly.
   - Limit number of concurrent threads to avoid CPU overload.
   - Can use ExecutorService or custom thread pool.

*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// =======================================================
// 1. Worker Thread for Custom Thread Pool
// =======================================================
class Worker extends Thread {
    private BlockingQueue<Runnable> taskQueue;
    private volatile boolean isRunning = true;

    public Worker(BlockingQueue<Runnable> queue, String name) {
        super(name);
        this.taskQueue = queue;
    }

    public void run() {
        try {
            while (isRunning) {
                Runnable task = taskQueue.take();
                if (task == SimpleThreadPool.POISON_PILL) {
                    break; // stop thread gracefully
                }
                task.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        isRunning = false;
        this.interrupt(); // unblock if waiting
    }
}

// =======================================================
// 2. Simple Thread Pool
// =======================================================
class SimpleThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private Worker[] workers;
    static final Runnable POISON_PILL = () -> { };

    public SimpleThreadPool(int poolSize) {
        taskQueue = new LinkedBlockingQueue<>();
        workers = new Worker[poolSize];

        // Create and start workers
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker(taskQueue, "Worker-" + (i + 1));
            workers[i].start();
        }
    }

    // Submit a task to the queue
    public void submit(Runnable task) {
        taskQueue.offer(task);
    }

    // Gracefully shutdown all workers
    public void shutdown() {
        for (int i = 0; i < workers.length; i++) {
            taskQueue.offer(POISON_PILL);
        }
    }
}

// =======================================================
// 3. Demo / Test Program
// =======================================================
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n=== SIMPLE THREAD POOL DEMO ===");
        SimpleThreadPool pool = new SimpleThreadPool(3); // 3 workers

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Executing Task " + taskId + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown after submitting tasks
        pool.shutdown();
    }
}

/*
==============================
SUMMARY
==============================
- Thread Pool: reusable threads that execute tasks from a queue.
- Benefits: performance, faster response, resource management.
- Workers pick tasks from queue; idle threads wait for tasks.
- POISON_PILL technique used to shutdown threads gracefully.
- Real-world use: servers, background tasks, periodic jobs.
==============================
*/
