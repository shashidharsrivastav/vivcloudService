package com.shashi.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
    private Integer minimum;
    private Integer maximum;

    //We are facing the problem is constructor and setupEnvironment(Application.properties)
//    protected Configuration() {
//    }
//
//    public Configuration(int minimum, int maximum) {
//        this.minimum = minimum;
//        this.maximum = maximum;
//    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }
}
