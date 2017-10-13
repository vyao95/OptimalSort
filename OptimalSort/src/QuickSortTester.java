package cs1c;

import java.io.*;

public class QuickSortTester {
	public static void compareRecursionLimit(int testSize)
    {
        int k, randomInt;
        long startTime, estimatedTime;

        // build two arrays for comparing sorts
        Integer[] arrayOfInts = new Integer[testSize];
        for (k = 0; k < testSize; k++)
        { 
            randomInt = (int) (Math.random() * testSize);
            arrayOfInts[k] = randomInt;
        }
        for(int i = 2; i <= 300; i+=2){
        	Integer[] test = arrayOfInts.clone();
        	FHsort.setRecursionLimit(i);
        	startTime = System.nanoTime();
			FHsort.quickSort(test);
			estimatedTime = System.nanoTime() - startTime;
			FileWriter out = null;
			PrintWriter writer = null;
			BufferedWriter bw = null;
			try{
				out = new FileWriter("RUN.txt", true);
				bw = new BufferedWriter(out);
				writer = new PrintWriter(bw);
				if(i == 2){
					writer.println("For an array of size "+testSize+" these are the runtimes of quicksort in nanoseconds from a recursion limit of 2 to 300.");
				}
				writer.println(estimatedTime);
				if(i == 300){
					writer.println();
				}
			} catch (Exception e){
				System.out.println("Error.");
			} finally {
				writer.close();
			}
			
        }
    }
	public static void main(String[] args){
		compareRecursionLimit(20000);
		compareRecursionLimit(100000);
		compareRecursionLimit(200000);
		compareRecursionLimit(300000);
		compareRecursionLimit(400000);
		compareRecursionLimit(500000);
		compareRecursionLimit(600000);
		compareRecursionLimit(700000);
		compareRecursionLimit(800000);
		compareRecursionLimit(900000);
		compareRecursionLimit(1000000);
	}

}
