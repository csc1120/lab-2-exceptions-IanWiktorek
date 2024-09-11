/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: wiktor_eki
 * Last Updated: 9/11/2024
 */

package wiktoreki;

import java.util.Random;

public class Die {


    public final int MIN_SIDES = 2;
    public final int MAX_SIDES = 100;

    private int currentSides;
    private int currentValue;
    private int numSides;
    Random random = new Random();

    Die(int numSides) throws IllegalArgumentException {

        if(numSides >= MIN_SIDES && numSides <= MAX_SIDES) {
            this.numSides = numSides;
            currentSides = numSides;
        }

        else
            throw new IllegalArgumentException("Please enter a number between 2 and 100");
    }

    //Returns the current value of the die and then sets the current value back to 0.
    public int getCurrentValue() throws DieNotRolledException{
        int returnedCurrentValue = 0;

        if(currentValue >= MIN_SIDES && currentValue <= currentSides)
        {
            returnedCurrentValue = currentValue;
            currentValue = 0;
            return returnedCurrentValue;
        }
        else
        {
            throw new DieNotRolledException();
        }

    }

    public void roll(){
        //Rolls the die and puts the rolled value into the current value variable.
        currentValue = random.nextInt(numSides) + MIN_SIDES;
    }


}