/**
 * @author Mr. Rasmussen
 */
package fracCalc;

import java.util.*;

public class FracCalc {
	static int idem2 = 1;
	static int inum2 = 0;
	static int iwhole2 = 0;
	static int idem1 = 1;
	static int inum1 = 0;
	static int iwhole = 0;
	static int recip = 1;
	static int wholeans = 0;
	static int fractans = 0;

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
		String input;
		boolean running = true;
		while (running) {
			input = userInput.nextLine();
			if (input.equals("Quit")) {	
				break;
			}else {
				produceAnswer(input);
			}
			//userInput.close();
		}
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
		idem2 = 1;
		inum2 = 0;
		iwhole2 = 0;
		idem1 = 1;
		inum1 = 0;
		iwhole = 0;
		recip = 1;
		wholeans = 0;
		fractans = 0;
		int a = input.indexOf(" ");
		String answer = "0";
		char op = input.charAt(a + 1);
		String imp1 = input.substring(0, a);
		String imp2 = input.substring(a + 3);
		if (imp2.indexOf("/") >= 0 && imp1.indexOf("/") >= 0) {
			parce2(imp2);
			parce1(imp1);
		} else if (imp2.indexOf("/") >= 0) {
			iwhole = parse(imp1);
			parce2(imp2);
		} else if (imp1.indexOf("/") >= 0) {
			iwhole2 = parse(imp2);
			parce1(imp1);
		} else {
			iwhole = parse(imp1);
			iwhole2 = parse(imp2);
		}
		if (iwhole < 0) {
			inum1 *= -1;
		}
		inum1 = (iwhole * idem1) + inum1;
		iwhole = 0;
		if (iwhole2 < 0) {
			inum2 *= -1;
		}
		inum2 = (iwhole2 * idem2) + inum2;
		iwhole2 = 0;
		if (op == '*') {
			inum1 *= inum2;
			idem1 *= idem2;
			wholeans = inum1 / idem1;
			fractans = inum1 % idem1;
		} else if (op == '/') {
			recip = idem2;
			idem2 = inum2;
			inum1 *= recip;
			idem1 *= idem2;
			wholeans = inum1 / idem1;
			fractans = inum1 % idem1;
		} else if (op == '+') {
			inum1 *= idem2;
			inum2 *= idem1;
			idem1 *= idem2;
			idem2 = idem1;
			inum1 += inum2;
			wholeans = inum1 / idem1;
			fractans = Math.abs(inum1 % idem1);
		} else {
			inum1 *= idem2;
			inum2 *= idem1;
			idem1 *= idem2;
			idem2 = idem1;
			inum1 -= inum2;
			wholeans = inum1 / idem1;
			fractans = inum1 % idem1;
		}
		int gcf = gdc(fractans, idem1);
		fractans /= gcf;
		idem1 /= gcf;
		if (fractans != 0 && wholeans != 0) {
			answer = (wholeans + "_" + Math.abs(fractans) + "/" + Math.abs(idem1));
		} else if (fractans != 0 && wholeans == 0) {
			answer = (fractans + "/" + Math.abs(idem1));
		} else if (fractans == 0 && wholeans != 0) {
			answer = (wholeans + "");
		}
		System.out.println(answer);
		return answer;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need
	public static int parse(String a) {
		int i = Integer.parseInt(a);
		return i;
	}

	public static int gdc(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return gdc(num2, num1 % num2);
	}

	public static void parce1(String imp) {
		int slash = imp.indexOf("/");
		idem1 = parse(imp.substring(slash + 1));
		if (imp.indexOf("_") >= 0) {
			int floor = imp.indexOf("_");
			inum1 = parse(imp.substring(floor + 1, slash));
			iwhole = parse(imp.substring(0, floor));
		} else if (imp.indexOf("_") <= 0) {
			inum1 = parse(imp.substring(0, slash));
		}
	}

	public static void parce2(String imp) {
		int slash = imp.indexOf("/");
		idem2 = parse(imp.substring(slash + 1));
		if (imp.indexOf("_") >= 0) {
			int floor = imp.indexOf("_");
			inum2 = parse(imp.substring(floor + 1, slash));
			iwhole2 = parse(imp.substring(0, floor));
		} else if (imp.indexOf("_") <= 0) {
			inum2 = parse(imp.substring(0, slash));
		}
	}
}