package jfcFormatter;

import java.util.Scanner;

class Jfc_Main {  
	public static void main(String args[])  
	{  
		String inputFile = "C:\\Users\\91814\\Desktop\\Result\\Input.txt";
		String outputFile = "C:\\Users\\91814\\Desktop\\Result\\";
		
//		Scanner sc= new Scanner(System.in); 
//		System.out.print("Input file path: ");  
//		String ip= sc.nextLine();      
//		
//		System.out.print("Output file path: ");  
//		String op= sc.nextLine();            
		
		Formatter.jfcFormatter(inputFile,outputFile);
	}
}