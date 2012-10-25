package randomize;
import java.util.Random; /*used for randomization*/
import java.util.Scanner; /*to accept input from the user*/

public class RandomizeArray {
	
	private int arraySize ; /*the size of the input array*/
	private String[] array ; /*Array entered by the user at the time of start of the program*/
	private String[] randomArray ; /*randomized array, changes after each randomization cycle*/
	private Integer[] status ; /*array to track wheather a specific value (index we got after randomization) of array is already taken or left*/
	

	private void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	public String[] getArray() {  
		return array;
	}

	private int getArraySize() {
		return arraySize;
	}
	private String[] getRandomArray() {
		return randomArray;
	}

	private void setRandomArray(String[] randomArray) {
		this.randomArray = randomArray;
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
		Boolean completed ; /*if this is false it means the random index returned by random function has returned a index that is still not used ans yes means that index value has been used randomize again and search for a value that is still not used*/
		String[] randomArray = new String[this.getArraySize()]; /*Local array, this array will contain the randomized array and will be used in setRandomArray method to set the value of actual random array. Intenionally kept local, so that if any change is required while setting value it can be inserted in set function*/
		status = new Integer[this.getArraySize()] ; /*If the index is used then it will inserted in the status array (Not recommended this way better)*/
		for (int i=0 ; i < this.getArraySize() ; i++)  /*Every element is randomized*/
		{	completed = true ; /*default value */
			while(completed) 
			{
				Random randomIndex = new Random();  
				int randomInt = randomIndex.nextInt(this.getArraySize()); /*randomized index*/
//				System.out.println(randomInt);
				completed = this.isIndexUsed(status, randomInt) ; /*check wheather this index is used or not*/
//				System.out.println(completed);
				if (!completed) /*if not used*/
				{
					status[i] = randomInt ; /*update the index*/
					randomArray[i] = array[randomInt] ;  /*update value in randomized array*/
//					System.out.println(status[i]);
//					System.out.println(randomArray[i]);
				}
			}

		}
		System.out.println("Following is randomized array :");
		this.printArray(randomArray); /*print the randomized array*/
	}
	
	private Boolean isIndexUsed(Integer[] status,int randomInt ) 
	{
		for (int j=0 ; j < this.getArraySize() ; j++) 
		{
			if ( status[j]!= null && status[j].intValue() == randomInt )  /*if that element whose index is outputted by random method is already used then use set completed to true need to rerandomize*/
			{
//				System.out.println(randomInt);
//				System.out.println( status[j]);
//				System.out.println( "true");
				return true ;
			}
		}
//		System.out.println( "false");
		return false ; /*Else no need to rerandmoize update the randomArray*/
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
