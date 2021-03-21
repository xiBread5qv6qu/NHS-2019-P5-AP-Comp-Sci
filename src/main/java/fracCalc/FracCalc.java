/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		String input;
		String int2;
		Scanner userInput = new Scanner(System.in);
		input = userInput.nextLine();		
		//produceAnswer(input);
		userInput.close();
		System.out.println(produceAnswer(input));
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
		char op = input.charAt(a + 1);
		String int1 = input.substring(0, a);
		String int2 = input.substring(a + 3);
		char n = int1.charAt(0);
		char d = int2.charAt(0);
		int dem1;
		int dem2;
		int num1;
		int num2;
		/*if (int1.indexOf("/") >= 0 && int2.indexOf("/") >= 0) {
			int b = int1.indexOf("/");
			num1 = int1.charAt(b - 1);
			dem1 = int1.charAt(b + 1);
			int c = int2.indexOf("/");
			num2 = int2.charAt(c - 1);
			dem2 = int2.charAt(c + 1);
			dem2 *= dem1;
			dem1  = dem2;
			num2 *= num1;
			num1 *= num2;
			if (op == *) {
				
			}else if () {
				
			}else if () {
				
			}else if () {
				
			}
		}else if () {
			
		}
		//if (b >= 0 && b >= 0) {
			
		}*/
		return int2;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
