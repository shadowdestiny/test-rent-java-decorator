package com.pattern.app.decorator.interfaces;

/**
 * Created by lmarin on 31/12/2017.
 */
public interface IRent {
    double charging(int time);
    double calculate(double charging);
    int getCountRent();
    int calculateCountRent();
}
