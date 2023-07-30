package org.example.LeakyBucket;

import org.example.RateLimiter;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LeakyBucket implements RateLimiter {

    BlockingQueue<Integer> queue;
    public LeakyBucket(int capacity) {
        this.queue = new LinkedBlockingQueue<>(capacity) ;
    }

    @Override
    public boolean allowAccess() {
        if(queue.remainingCapacity() > 0){
            queue.add(1);
            return true;
        }
        return false;
    }
}
