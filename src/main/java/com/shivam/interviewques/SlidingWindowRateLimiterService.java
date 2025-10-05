package com.shivam.interviewques;

import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowRateLimiterService {


    public int maxRequestsPerMinute;
    public long windowSizeSeconds;

    // Thread-safe deque to store timestamps of requests
    private final Deque<Long> requestTimestamps = new ConcurrentLinkedDeque<>();

    /**
     * Attempt to consume a request slot.
     *
     * @return true if request is allowed, false if rate limit exceeded
     */

    public synchronized boolean tryConsume() {
        long now = Instant.now().toEpochMilli();

        while (!requestTimestamps.isEmpty() && now - requestTimestamps.peekFirst() >= windowSizeSeconds) {
            requestTimestamps.pollFirst();
        }

        if (requestTimestamps.size() < maxRequestsPerMinute) {
            requestTimestamps.addLast(now);
            return true;
        } else {
            return false;
        }
    }

}