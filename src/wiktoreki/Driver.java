/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: wiktor_eki
 * Last Updated: 9/17/2024
 */
package wiktoreki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public final int MIN_DICE = 2;
    public final int MAX_DICE = 10;

    private static int[] getInput(){
        System.out.println("Please enter the number of dice to roll, how many sides the dice have, and how many rolls to complete, separating the values with a space.");
        System.out.println("Example: \"2 6 1000\"");
        System.out.println();
        System.out.println("Enter configuration:");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        return null;



    }


    private static List<Die> createDice(int numDice, int numSides){

        List<Die> dice = new ArrayList<Die>();
        int numCreated = 0;

        while(numCreated < numDice){
            
            Die tempDice = new Die(numSides);
            dice.add(tempDice);
            numCreated++;

        }

        return dice;

    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int currentDiceNumber = 0;
        int currentNumRolls = 0;
        int[] rolls = new int[numRolls*numSides];
        while(currentNumRolls < numRolls){
            dice[currentDiceNumber].roll();
            rolls[(dice[currentDiceNumber].getCurrentValue() - numRolls)]++;
            currentNumRolls++;
        }

        return rolls;

    }

    private static int findMax(int[] rolls){

        int max = 0;
        for(int i=0; i<rolls.length; i++){
            if(rolls[i] > max){
                max = rolls[i];
            }
        }

        return max;

    }

    private static void report(int numDice, int[] rolls, int max, int numRolls){
        int scale = max/10;
        int numStars = 0;
        if(scale > 0){
            numStars = numRolls / scale;
        }
        else{
            scale = 1;
            numStars = numRolls / scale;
        }

        for(int i=0; i<rolls.length; i++){

            System.out.printf(0+numRolls + " :" + rolls[i] + "     " +);

        }

    }



    public static void main(String[] args) {


    }



}