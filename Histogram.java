/*Histogram
Purpose: Make a "bar graph" of how many times a specific single-digit integer is used from user inputs
Scott Coonis
9/5/20
 */

import java.util.Scanner;

public class Histogram
{
    public static void main(String[] args)
    {
        //variables
        Scanner keyboard = new Scanner(System.in);
        int numInputs = 1, temp, maximum = 0;
        int[] numbers = new int[31];
        int[] count = new int[31];
        boolean success = false;

        //start of program
        System.out.println("How many input values [max:30]?");

        //while no valid input
        while (!success)
        {
            try
            {
                numInputs = keyboard.nextInt(); //get a number
                numInputChecker(numInputs);     //is it valid?
                success = true;                 //ok

            } catch (Exception e)                 //else get a new number
            {
                keyboard.nextLine();
                System.out.println("Whole numbers 1 through 30 only, please.");

            }
        }
        //reset the loop checker
        success = false;

        //read numbers to fill that array
        System.out.println("Enter " + numInputs + " numbers.");

        for (int i = 0; i < numInputs; i++)     //from 0 to max number
        {
            while (!success)                   //while no valid number
            {
                try
                {
                    numbers[i] = keyboard.nextInt();    //fill the current cell with a number
                    numberChecker(numbers[i]);          //is it valid?
                    success = true;                     //ok
                } catch (Exception e)                   //else get a new number
                {
                    keyboard.nextLine();
                    System.out.println("Whole numbers 0 through 9 only, please.");
                }
            }
            success = false;
        }

        //for cells not used
        for (int i = numInputs; i < numbers.length; i++)
        {
            numbers[i] = -1;    //fill with garbage data (to prevent false positive 0s)
        }

        //take the input and count each use of element
        for (int i : numbers)  //for 0 to max number
        {
            if (i != -1)       //if valid data
            {
                temp = i;           //get the current value of the cell
                count[temp]++;      //add the use of that value to a new array's cell
            }

        }

        System.out.println("Number Occurrence");

        for (int i = 0; i < count.length; i++)   //from 0 to 9 (expected)
        {
            if (count[i] > 0)  //if cell has valid data
            {
                System.out.println(i + " " + count[i]);  //print the current cell and how many times it was used
            }
        }
        System.out.println();   //spacer

        //histogram segment

        //find the highest-used number
        for (int k : count)              //for 0 to 9
        {
            if (k > maximum)             //if greater than the current max
            {
                maximum = k;             //set to max
            }
        }

        System.out.println("========= Vertical Bar ========");

        for (int i = maximum; i > 0; i--) // from max to 1
        {
            System.out.print("| " + (i) + " |  ");    //print the number and a spacer for visibility


            for (int j = 0; j < count.length; j++)   // from 0 to max
            {

                    if (count[j] >= i)                    // If the count at this position horizontally is greater than or
                                                          // equal to the count vertically (the line number we're on)
                    {
                        System.out.print("* ");           //print an asterisk
                    }
                    else
                        {
                            System.out.print("  ");       //else print a blank
                        }
            }
            System.out.println();                         //spacer
        }
        //footer
        System.out.println("===============================");
        System.out.println("| No | 0 1 2 3 4 5 6 7 8 9");
        System.out.println("===============================");
        }

    static void numInputChecker(int integer) throws Exception
    {
        if ((integer < 1) || (integer > 30))    //if 0 or negative, or if 31+
        {
            throw new Exception();              //say no
        }
    }

    static void numberChecker(int integer) throws Exception
    {
        if ((integer < 0) || (integer > 9)) //if negative or 10+
        {
            throw new Exception();          //say no
        }
    }

}
