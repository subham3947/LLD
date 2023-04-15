package com.doremi.entity;

import java.util.Date;

import com.doremi.constants.SubscriptionCategory;
import com.doremi.constants.SubscriptionPlan;

public class Subscription {

    SubscriptionCategory category;
    SubscriptionPlan plan;
    Date startDate;
    Date endDate;
    Date renewalReminderDate;
    
}
