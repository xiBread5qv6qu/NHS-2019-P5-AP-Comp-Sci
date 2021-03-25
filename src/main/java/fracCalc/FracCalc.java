/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {
	static int idem2 = 0;
	static int inum2 = 0;
	static int iwhole2 = 0;
	static int idem1 = 0;
	static int inum1 = 0;
	static int iwhole = 0;

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		String input;
		Scanner userInput = new Scanner(System.in);
		input = userInput.nextLine();
		produceAnswer(input);
		userInput.close();
		System.out.println("whole:" + iwhole2 + " numerator:" + inum2 + " denominator:" + idem2);
		//System.out.println("whole:" + iwhole + " numerator:" + inum1 + " denominator:" + idem1);
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		int a = input.indexOf(" ");
		String num2 = "0";
		String dem2 = "1";
		String whole2 = "0";
		String num1 = "0";
		String dem1 = "1";
		String whole = "0";
		String answer = "0";
		char op = input.charAt(a + 1);
		String imp1 = input.substring(0, a);
		String imp2 = input.substring(a + 3);
		//System.out.println("abc");
		
		
		if (imp2.indexOf("/") >= 0 && imp1.indexOf("/") >= 0) {
			if (imp2.indexOf("/") >= 0) {
				int slash = imp2.indexOf("/");
				dem2 = imp2.substring(slash + 1);
				if (imp2.indexOf("_") >= 0) {
					int floor = imp2.indexOf("_");
					num2 = imp2.substring(floor + 1, slash);
					whole2 = imp2.substring(0, floor);
				} else {
					num2 = imp2.substring(0, slash);
				}
	
			} else {
				whole2 = imp2;
			}
			
			if (imp1.indexOf("/") >= 0) {
				int slash = imp1.indexOf("/");
				dem1 = imp1.substring(slash + 1);
				if (imp1.indexOf("_") >= 0) {
					int floor = imp1.indexOf("_");
					num1 = imp1.substring(floor + 1, slash);
					//System.out.println(num1);
					whole = imp1.substring(0, floor);
				} else {
					num1 = imp1.substring(0, slash);
				}
	
			} else {
				whole = imp1;
			}
		
		
		}
		
	
		else if (imp2.indexOf("/") >= 0) {
			whole = imp1;
			int slash = imp2.indexOf("/");
			dem2 = imp2.substring(slash + 1);
			if (imp2.indexOf("_") >= 0) {
				int floor = imp2.indexOf("_");
				num2 = imp2.substring(floor + 1, slash);
				whole2 = imp2.substring(0, floor);
			} else if (imp2.indexOf("_") <= 0) {
				num2 = imp2.substring(0, slash);
			}
	
			else {
			whole2 = imp2;
			}
		}
		
		else if (imp1.indexOf("/") >= 0) {
			//System.out.println("abc");
			whole2 = imp2;
			//System.out.println(whole2);
			int slash = imp1.indexOf("/");
			dem1 = imp1.substring(slash + 1);
			if (imp1.indexOf("_") >= 0) {
				int floor = imp1.indexOf("_");
				num1 = imp1.substring(floor + 1, slash);
				whole = imp1.substring(0, floor);
			} else if (imp1.indexOf("_") <= 0) {
				num1 = imp1.substring(0, slash);
				//System.out.println("abc");
			}
	
			else {
			whole = imp1;
			}
		}
		
		else {
			whole = imp1;
			whole2 = imp2;
		}
			
		
		//System.out.println(iwhole2);
		inum2 = Integer.parseInt(num2);
		//System.out.println(iwhole2);
		idem2 = Integer.parseInt(dem2);
		//System.out.println(iwhole2);
		iwhole2 = Integer.parseInt(whole2);
		//System.out.println(iwhole2);
		inum1 = Integer.parseInt(num1);
		//System.out.println(iwhole2);
		idem1 = Integer.parseInt(dem1);
		//System.out.println(iwhole2);
		iwhole = Integer.parseInt(whole);
		//System.out.println(inum1);
		if (imp1.indexOf("_") >= 0) {
			//inum1 = iwhole * (idem1 + inum1);
			//iwhole = 0;
		}
		if (imp2.indexOf("_") >= 0) {
			//inum2 = iwhole2 * (idem2 + inum2);
			//iwhole2 = 0;
		}
		//idem1 *= idem2;
		//inum1 *= inum2;
		//System.out.println(iwhole2);
		//System.out.println(num2);
		if (op == '*') {
			inum1 *= inum2;
			idem1 *= idem2;
			int wholeans = inum1 / idem1;
			int fractans = inum1 % idem1;
			answer = (wholeans + "_" + fractans + "/" + idem1);
		}
		String h = ("whole:" + iwhole2 + " numerator:" + inum2 + " denominator:" + idem2);
		//System.out.println(answer);
		//System.out.println(idem1);
		//System.out.println(iwhole);
		//System.out.println(inum1);
		//System.out.println(idem2);
		//System.out.println(iwhole2);
		return h;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
