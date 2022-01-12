package chapter4;
/*
Travel a game board of 20 spaces within 5 die rolls or less, but they cannot go over 20 spaces.
 */

import java.util.Random;

public class RollTheDice<maxRolls, rolls, i> {

    public static void main(String args[]){
        //Initialize Known Values
        int finalPosition = 20;
        int currentPosition = 0;
        //int rolls = 0;
        int spacesRemaining;
        int maxRolls= 5;

        /*
        Loop to calculate position on the board
        position = 0
        add a die roll amount
        see if position = 20 yeah you win
        if less and rolls less than 5 roll again and tell has x spaces to go
        if greater than sorry you went over
        */
        System.out.println("You have 5 die rolls to move exactly 20 spaces on the board. Let's begin");
        for(int rolls=0; rolls<maxRolls; rolls++){

            Random random = new Random();
            int die = random.nextInt(6) + 1;
            //int rolls = i;

            currentPosition = currentPosition + die;
            spacesRemaining = finalPosition - currentPosition;
            if (currentPosition < finalPosition) {
                System.out.println("Roll #" + (rolls+1) + ": You've rolled a " + die + ". You are now on space " + currentPosition +
                        " and have " + spacesRemaining + " more spaces to go.");
            }else if (currentPosition == finalPosition){
                System.out.println("Roll #" + (rolls+1) + ": You've rolled a " + die + ". You won in " + (rolls+1) + " rolls!");
                break;
            }else if (currentPosition > finalPosition){
                System.out.println("Roll #" + (rolls+1) +": Sorry you rolled a " + die + " and went over by "
                        + (currentPosition-finalPosition) + " spaces.");
                break;
            }

        }
        if (currentPosition<finalPosition)
            System.out.println("Sorry you ran out of rolls.");
    }
}
