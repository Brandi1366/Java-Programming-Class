package chapter9;

public class TasteTester {

    public static void main (String arg[]){

        WeddingCake myWedding  = new WeddingCake();
        myWedding.setTiers(5);
        myWedding.setFlavor("strawberry shortcake");

        System.out.println("My " + myWedding.getFlavor() + " wedding cake will have " + myWedding.getTiers() + " tiers.");

        BirthdayCake babysBirthday = new BirthdayCake();
        babysBirthday.setFlavor("vanilla");
        babysBirthday.setCandles(5);
        babysBirthday.setPrice(35.99);

        System.out.println("The baby's birthday " + babysBirthday.getFlavor() + " cake will have "
                + babysBirthday.getCandles() + " candles, and it will cost " + babysBirthday.getPrice() + " to make.");


    }
}
