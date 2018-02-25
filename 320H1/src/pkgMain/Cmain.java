/*
 * @ Marc Bolinas
 * 
 * CISC320
 * Programming Assignment 1
 * 2/25/18
 */

package pkgMain;

import java.io.*;

public class Cmain {
	
	//Default file locations. Might want to change these before running
	static String input = "K:\\Downloads\\input.txt";
	static String output = "K:\\Downloads\\output.txt";
	
	public static void main(String[] args) throws IOException{

		BufferedReader reader = new BufferedReader(new FileReader(input));
		BufferedWriter writer = new BufferedWriter(new FileWriter(output));
		String line = reader.readLine();
		
		//Reads a line, calculates 'max' using the given algorithm, writes the line and answer to output.txt
		while(line != null) {
			String[] values = line.split(" ");
			
			String result = alg(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
			writer.write(result);
			writer.newLine();

			
			line = reader.readLine();
		}
		
		reader.close();
		writer.close();
	}
	
	public static String alg(int i, int j) {
		
		int current = Math.max(i,j);
		int end = Math.min(i,j);
		int max = 0;
		
		//For each number between current and end (between i and j), calculate count based on the number of iterations through the algorithm
		//Returns the highest count
		while (current > end) {
			int start = current;
			int count = 1;
			
			while(start != 1) {
				if(start % 2 == 0) {
					start = start/2;
					count++;
				}
				else {
					start = (start * 3) + 1;
					count++; 
				}
			}
			
			max = Math.max(count, max);
			current--;
		}
		
		return i + " "+ j + " " + max;
	}
}
