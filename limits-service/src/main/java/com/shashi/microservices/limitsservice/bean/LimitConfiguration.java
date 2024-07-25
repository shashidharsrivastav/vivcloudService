package com.shashi.microservices.limitsservice.bean;

import com.shashi.microservices.limitsservice.LimitsServiceApplication;

public class LimitConfiguration {
    private int maximum;
    private int minimum;

    protected LimitConfiguration(){}
    public LimitConfiguration(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }

}
