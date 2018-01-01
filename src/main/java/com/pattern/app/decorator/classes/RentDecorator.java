package com.pattern.app.decorator.classes;

/**
 * Created by lmarin on 31/12/2017.
 */
public abstract class RentDecorator extends Rent{
    private Rent rent;
    public RentDecorator(Rent rent){
        this.rent = rent;
    }
    public double charging(int time){
        return rent.charging(time);
    }
    public double calculate(double charging){
        return rent.calculate(charging);
    }
    public int calculateCountRent(){
        return rent.calculateCountRent();
    }
    public int getCountRent(){
        return rent.getCountRent() ;
    }

}
