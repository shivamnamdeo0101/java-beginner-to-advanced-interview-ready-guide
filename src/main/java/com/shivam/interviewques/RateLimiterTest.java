package com.shivam.interviewques;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Thread-safe sliding window rate limiter.
 * Supports high concurrency for single-instance Spring Boot applications.
 */



public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiterService limiter = new SlidingWindowRateLimiterService();

        // Manually set configuration values for test
        limiter.maxRequestsPerMinute = 5;   // max 5 requests
        limiter.windowSizeSeconds = 10;     // per 10 seconds window

        // Simulate 10 rapid requests
        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.tryConsume();
            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Blocked"));
            //Thread.sleep(1000); // 1 second between requests
        }

        // Wait for window to expire
        System.out.println("Waiting for window to expire...");
        Thread.sleep(9000);

        // Try again after window
        for (int i = 1; i <= 15; i++) {
            boolean allowed = limiter.tryConsume();
            System.out.println("Request after window : Req " + i + ": " + (allowed ? "Allowed" : "Blocked"));
        }
    }
}
