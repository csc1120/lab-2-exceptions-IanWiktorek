/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: wiktor_eki
 * Last Updated: 9/11/2024
 */
package wiktoreki;

public class DieNotRolledException extends RuntimeException  {

    public String getMessage(){

        return ("The die could not be rolled because the value was out of range");

    }

}
