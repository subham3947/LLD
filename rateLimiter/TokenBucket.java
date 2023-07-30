package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter{

    private final int bucketCapacity;
    private final int refreshRate;
    private AtomicInteger currentcapacity;
    private AtomicLong lastUpdatedTime;

    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        currentcapacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean allowAccess() {
        refreshBucket();
        if(currentcapacity.get() > 0){
            currentcapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refreshBucket() {

        long currentTime = System.currentTimeMillis();
        int additionalTokens = (int)(currentTime - lastUpdatedTime.get())/1000 * refreshRate;
        currentcapacity.getAndSet(Math.min(currentcapacity.get() +  additionalTokens, bucketCapacity));
        lastUpdatedTime.getAndSet(currentTime);
    }
}
