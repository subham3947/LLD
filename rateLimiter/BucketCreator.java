package org.example;

import java.util.HashMap;
import java.util.Map;

public class BucketCreator {

    Map<Integer, TokenBucket> bucketMap;

    public BucketCreator(int id) {
        bucketMap = new HashMap<>();
        bucketMap.put(id, new TokenBucket(10, 10));
    }


    public void accesApplication(int id){
        if(bucketMap.get(id).allowAccess())
            System.out.println("Access allowed for "+Thread.currentThread().getName());
        else
            System.out.println("Access denied for "+Thread.currentThread().getName()+". Too many requests");
    }
}
