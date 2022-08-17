package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.*;
import com.kodilla.patterns2.decorator.taxiportal.ExpressDecorator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {


    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Make a standard pizza", description);
    }

    @Test
    public void testMoreCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    public void testMoreCheeseGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Make a standard pizza with 100g additional cheese", description);
    }

    @Test
    public void testAdditionalHamGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(26), theCost);
    }

    @Test
    public void testAdditionalHamGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Make a standard pizza with 100g additional cheese with 100g additional ham", description);
    }

    @Test
    public void testAdditionalVegetablesGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new VegetablesDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(32), theCost);
    }

    @Test
    public void testAdditionalVegetablesGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new VegetablesDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Make a standard pizza with 100g additional cheese with 100g additional ham with 100g additional vegetables", description);
    }

    @Test
    public void testAdditionalMushroomsGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new VegetablesDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(35), theCost);
    }

    @Test
    public void testAdditionalMushroomsGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MoreCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new VegetablesDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Make a standard pizza with 100g additional cheese with 100g additional ham with 100g additional vegetables with 100g additional mushrooms", description);
    }
}
