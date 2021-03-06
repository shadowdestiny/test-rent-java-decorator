package com.pattern.app.decorator.classes;

import com.mycompany.consts.RentConsts;

/**
 * Created by hitok on 31/12/2017.
 */
public class RentByWeek extends RentDecorator{
    public RentByWeek(Rent rent) {
        super(rent);
    }
    public double charging(int time){
        super.calculateCountRent();
        return (super.charging(time) + (time * RentConsts.RENT_WEEK));
    }
}
