package com.doremi;

import java.util.Date;

import com.doremi.constants.SubscriptionCategory;
import com.doremi.entity.MusicSubscription;
import com.doremi.entity.PodcastSubscription;
import com.doremi.entity.Subscription;
import com.doremi.entity.VideoSubscription;

public class SubscriptionFactory {

    public static final String MUSIC_CATEGORY = SubscriptionCategory.MUSIC.name();

    public Subscription getSubscription(Date startDate, SubscriptionCategory category, String plan){

        Subscription subscription = null;

        switch(category){

            case MUSIC:
                subscription = new MusicSubscription();
                break;
            case PODCAST:
                subscription = new PodcastSubscription();
                break;
            case VIDEO:
                subscription = new VideoSubscription();
                break;
            default:
                break;
        }

        return subscription;
    }
    
}
