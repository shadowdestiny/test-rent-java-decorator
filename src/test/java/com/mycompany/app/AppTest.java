package com.mycompany.app;

import com.mycompany.consts.RentConsts;
import com.pattern.app.decorator.classes.Rent;
import com.pattern.app.decorator.classes.RentByDay;
import com.pattern.app.decorator.classes.RentByHours;
import com.pattern.app.decorator.classes.RentByWeek;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * Test by hour
     * @author: lmarin
     * @date 01.01.2018
     */
    public void testHour()
    {
        RentByHours rentByHours = new RentByHours(new Rent());
        int hour = 1;
        double result = rentByHours.calculate(rentByHours.charging(hour));
        assertEquals((double)RentConsts.RENT_HOUR * (double)hour, result);
        assertTrue( true );
        System.out.println(result);
    }
    /**
     * Rigourous Test :-)
     * Test by day
     * @author: lmarin
     * @date 01.01.2018
     */
    public void testDay()
    {
        RentByDay rentByDay = new RentByDay(new Rent());
        int day = 1;
        double result = rentByDay.calculate(rentByDay.charging(day));
        assertEquals((double)RentConsts.RENT_DAY * (double)day, result);
        assertTrue( true );
        System.out.println(result);
    }
    /**
     * Rigourous Test :-)
     * Test by week
     * @author: lmarin
     * @date 01.01.2018
     */
    public void testWeek()
    {
        RentByWeek rentByWeek = new RentByWeek(new Rent());
        int week = 1;
        double result = rentByWeek.calculate(rentByWeek.charging(week));
        assertEquals((double)RentConsts.RENT_WEEK * (double)week, result);
        assertTrue( true );
        System.out.println(result);
    }
    /**
     * Rigourous Test :-)
     * Test case family all type
     * @author: lmarin
     * @date 01.01.2018
     * promotion Family rental incluying 3 intances
     */
    public void testFamily()
    {
        // inyectando dependencias
        Rent rent = new RentByWeek(new RentByDay(new RentByHours(new Rent())));
        int time = 1;
        double result = rent.calculate(rent.charging(time));
        assertEquals(85.0 - (85.0 * RentConsts.FAMILY_RENTAL / 100), result);
        assertTrue( true );
        System.out.println(result);
    }
    /**
     * Rigourous Test :-)
     * Test case family all type
     * @author: lmarin
     * @date 01.01.2018
     * promotion Family rental incluying 2 intances (without discount)
     */
    public void testFamilyTwo()
    {
        // inyectando dependencias
        Rent rent = new RentByDay(new RentByHours(new Rent()));
        int time = 1;
        double result = rent.calculate(rent.charging(time));
        assertEquals(25.0, result);
        assertTrue( true );
        System.out.println(result);
    }
    /**
     * Rigourous Test :-)
     * Test case family all type
     * @author: lmarin
     * @date 01.01.2018
     * promotion Family rental greater than five (without discount)
     */
    public void testFamilySix()
    {
        // inyectando dependencias
        Rent rent = new RentByWeek(new RentByDay(new RentByHours(new RentByWeek(new RentByDay(new RentByHours(new Rent()))))));
        int time = 1;
        double result = rent.calculate(rent.charging(time));
        assertEquals(170.0, result);
        assertTrue( true );
        System.out.println(result);
    }
}
