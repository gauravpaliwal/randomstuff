
/*This is the main class, that will execute the program*/

import randomize.RandomizeArray; /*Business Logic*/
import java.util.Scanner;


public class ArrayRandomize {


	public static void main(String[] args) {
		// TODO code application logic here
		RandomizeArray randomizeArray = new RandomizeArray() ; /*Create a new object of the class that contain the logic*/
		randomizeArray.createArray(); /*This function will initilize the array*/
		System.out.println("You entered following array :");
		randomizeArray.printArray(randomizeArray.getArray()); /*This will print the initial array*/
		randomizeArray.randomize(); /*randomize the array and print the randamized array*/
		Boolean retry =true;
		while(retry) /*Decide what the user want to do after 1 randomization.*/
		{
			System.out.println("If you want to rerandomize press type 0 and to exit press 1 ") ;
			Scanner scan = new Scanner(System.in) ;
			if (!scan.hasNextInt())
			{
				System.out.println("We only accepts Boolean. Randomize(0) or Exit(1).") ; /*No Exception handling just a prompt that they should select the proper input*/
			}
			else if (scan.nextInt()==0) 
			{
				randomizeArray.randomize(); /*Randomize the program again*/
			}
			
			else
			{
				retry = false ; /*Exit the JVM*/
			}
			
		}
		
	}
}
