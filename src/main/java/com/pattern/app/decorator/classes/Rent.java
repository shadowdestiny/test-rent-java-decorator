package com.pattern.app.decorator.classes;

import com.mycompany.consts.RentConsts;
import com.pattern.app.decorator.interfaces.IRent;

/**
 * Created by lmarin on 31/12/2017.
 */
public class Rent implements IRent {
    //protected double amount = 0;
    private int count = 0;
    public double charging(int time) {
        return 0;
    }
    public double calculate(double charging) {
        return charging - (charging * (this.getCountRent() >= RentConsts.NUM_MIN_INTANCES && this.getCountRent() <= RentConsts.NUM_MAX_INTANCES
                ? ((double)RentConsts.FAMILY_RENTAL / (double)100) : 0));
    }
    public int getCountRent(){
        return this.count;
    }
    public int calculateCountRent(){
        return this.count++;
    }
}
