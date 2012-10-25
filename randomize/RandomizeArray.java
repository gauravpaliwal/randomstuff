package randomize;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random; /*used for randomization*/
import java.util.Scanner; /*to accept input from the user*/

public class RandomizeArray {
	
	private int arraySize ; /*the size of the input array*/
	private String[] array ; /*Array entered by the user at the time of start of the program*/
	

	private void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	public String[] getArray() {  
		return array;
	}

	private int getArraySize() {
		return arraySize;
	}
	
	private void setArray(String[] array) {
		this.array = array;
	}

	
	public void createArray()  /*This will initialize the array with size and the elements values*/
	{
		Scanner scan = new Scanner(System.in) ;
		System.out.println("Please Enter the size of the Array : ") ;
		if (scan.hasNextInt())
		{
			this.setArraySize((int)scan.nextInt());
			array = new String[this.getArraySize()] ;
		}
		else
		{
			System.out.println("Program terminated, we don't handle exception. Please restart the program") ;
			System.exit(1) ;
		}
		System.out.println("Please enter " + this.getArraySize() + " element and 1 element per line") ;

		for (int i = 0 ; i < this.getArraySize() ; i++)
		{
			scan = new Scanner(System.in) ;
			this.array[i] = scan.nextLine() ;
		}
		
		//String[] array = {"a" , "b" , "abcd" , "abcd" , "sddsf" , "sdfdsf"} ;
		//this.setArray(array);
		//this.setArraySize(6);
	}
	
	public void randomize() /*This function will randomize the array and prints the output*/
	{
		System.out.println("Randomized Array : ") ;
		Collections.shuffle(Arrays.asList(array));
		this.printArray(array); /*print the randomized array*/
	}
	
	
	
	public void printArray(String[] Array)  /*to print the array*/
	{			
		System.out.print ("| ");
		for (int i=0 ; i < this.getArraySize() ; i++) 
		{
			System.out.print(Array[i] + " | ");
		}
		System.out.println() ;
	}

}

