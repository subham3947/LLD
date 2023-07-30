package org.example.SlidingWindow;

import org.example.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter {

    Queue<Long> requestQueue;
    int windowSizeInSeconds;
    int queueCapacity;

    public SlidingWindow(int windowSizeInSeconds, int queueCapacity) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.queueCapacity =queueCapacity;
        requestQueue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean allowAccess() {
        long currentTime = System.currentTimeMillis();
        updateQueue(currentTime);
        if(queueCapacity > requestQueue.size()){
            requestQueue.offer(currentTime);
            return true;
        }
        return false;
    }

    private void updateQueue(long currentTime) {
        if(requestQueue.isEmpty()) return;
        int timeElapsedInSeconds = (int)(currentTime - requestQueue.peek())/1000;

        while(!requestQueue.isEmpty() && timeElapsedInSeconds >= windowSizeInSeconds){
            requestQueue.poll();
            timeElapsedInSeconds = (int)(currentTime - requestQueue.peek())/1000;
        }
    }
}
