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

import static wiktoreki.Die.MAX_SIDES;
import static wiktoreki.Die.MIN_SIDES;

public class Driver {

    public final int MIN_DICE = 2;
    public final int MAX_DICE = 10;

    private static void getInput(){
        boolean con1 = true;
        boolean validInput = false;

        while(!validInput) {
            System.out.println("Please enter the number of dice to roll, how many sides the dice have, and how many rolls to complete, separating the values with a space.");
            System.out.println("Example: \"2 6 1000\"");
            System.out.println();
            System.out.println("Enter configuration:");

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            if (userInput.length() - userInput.replaceAll(" ", "").length() < 2) {
                System.out.println("Invalid input: Expected 3 variables but only received " + userInput.replaceAll(" ", "").length());
                con1 = false;
            }
            else{
                con1 = true;
            }

            int firstIndex = 0;
            int secondIndex = 0;
            String updatedInput = "";
            int numberOne = 0;
            int numberTwo = 0;
            int numberThree = 0;

            while(userInput.contains(" ")){
                firstIndex = userInput.indexOf(" ");
                secondIndex = userInput.indexOf(" ", firstIndex+1);
                updatedInput = userInput.substring(0,firstIndex) + userInput.substring(firstIndex+1, secondIndex) + userInput.substring(secondIndex+1);
                userInput = updatedInput;
                try{
                    numberOne = Integer.parseInt(updatedInput.substring(0, firstIndex));
                    numberTwo = Integer.parseInt(updatedInput.substring(firstIndex, secondIndex-1));
                    numberThree = Integer.parseInt(updatedInput.substring(secondIndex-1));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: All values must be whole numbers.");
                    con1 = false;
                }
            }

            if(con1){
                report(numberOne, numberTwo, rollDice(createDice(numberOne, numberTwo), numberTwo, numberThree, numberOne), numberThree);
                validInput = true;
            }
        }

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

    private static int[] rollDice(List<Die> dice, int numSides, int numRolls, int numDice){
        int currentDiceNumber = 0;
        int currentNumRolls = 0;
        int total = 0;
        int[] rolls = new int[numDice*numSides-1];
        while(currentNumRolls < numRolls){
            currentDiceNumber = 0;
            while(currentDiceNumber < numDice) {
                dice.get(currentDiceNumber).roll();
                total += dice.get(currentDiceNumber).getCurrentValue();
                currentDiceNumber++;
            }

            rolls[total - numDice]++;
            total = 0;

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

    private static void report(int numDice, int numberTwo, int[] rolls, int numRolls){
        int max = findMax(rolls);
        int scale = max/10;

        for (int a = 0; a < numberTwo*numDice-(numDice-1); a++) {


            int numStars = 0;
            String star = "*";
            String temp = "";
            String finalStars = "";
            if(scale > 0){
                numStars = (rolls[a] / scale);
            }
            else{
                scale = 1;
                numStars = numRolls / scale;
            }
            for (int s = 1; s <= numStars; s++) {
                temp = temp + star;
            }
            finalStars = temp;


            System.out.println(numDice+a + " :" + rolls[a] + "     " + finalStars);

        }

    }



    public static void main(String[] args) {

        getInput();


    }



}