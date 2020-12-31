package csc400;
/* Takes a system in where data = data points that were provided in the problem set
 * Does NOT give decimal points and truncates, returning a whole number
 * Data is expected to be entered with spaces between operators and integers ex: data1 - data2
 * except where parens are used, ex: (data1 - data2)
 */
import java.util.Scanner;
import java.io.IOException;

public class PostFixTestClass {
    public static void main(String[] args) throws IOException{
        String expression;
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter expression: ");
        expression = scnr.nextLine();

        PostFixConverter pc = new PostFixConverter(expression); 

        PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());
        System.out.println("Result: " + calc.result());
    }

}
