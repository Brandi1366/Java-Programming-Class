package chapter9;
/*
*Cake! Cake! Cake!
For your optional exercise, you're going to create four classes.
-The first one is going to be a superclass called Cake and it will have two fields, flavor and price. Go ahead and make
getter and setter methods for both of these fields.
-Next create a BirthdayCake class which will inherit from the Cake class and it has a field of its own called candles.
Go ahead and include the getter and setter method for candles.
-And then create a third class called WeddingCake which also inherits from Cake and has a field called tiers and you'll
include a getter and setter method for this.
-And then finally, a class called TasteTester which will test out your inheritance.

*/
public class Cake {

    private String flavor;
    private double price;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
