/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: wiktor_eki
 * Last Updated: 9/11/2024
 */

package wiktoreki;

import java.util.Random;

public class Die extends Driver{


    public static final int MIN_SIDES = 2;
    public static final int MAX_SIDES = 100;

    private int currentSides;
    private int currentValue;
    private int numSides;
    Random random = new Random();

    Die(int numSides) throws IllegalArgumentException {

        this.currentValue = 0;
        int currentDiceValue;

        if(numSides >= MIN_SIDES && numSides <= MAX_SIDES) {
            try {
                this.numSides = numSides;
                currentSides = numSides;
            }
            catch(IllegalArgumentException e) {
                throw new IllegalArgumentException("numSides must be between " + MIN_SIDES + " and " + MAX_SIDES);
            }
        }
    }

    //Returns the current value of the die and then sets the current value back to 0.
    public int getCurrentValue() throws DieNotRolledException{
        int returnedCurrentValue = 0;

        if(currentValue >= 1 && currentValue <= currentSides)
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
        this.currentValue = random.nextInt(MIN_SIDES-1, numSides+1);
    }


}