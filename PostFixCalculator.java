package csc400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostFixCalculator {
    private List<String> expression = new ArrayList<String>();
    private Deque<Integer> stack = new ArrayDeque<Integer>();

    public PostFixCalculator(List<String> postfix) {expression = postfix;} // After fixed


    public Integer result(){
        for(int i = 0; i != expression.size(); ++i){ // Check for integer/operator
            if(Character.isDigit(expression.get(i).charAt(0))){
                stack.addLast(Integer.parseInt(expression.get(i)));
            }
            else 
            {
                double tempResult = 0;
                double temp;

                switch(expression.get(i))
                {
                    case "+": temp = stack.removeLast();
                              tempResult = stack.removeLast() + temp;
                              break;

                    case "-": temp = stack.removeLast();
                              tempResult = stack.removeLast() - temp;
                              break;

                    case "*": temp = stack.removeLast();
                              tempResult = stack.removeLast() * temp;
                              break;

                    case "/": temp = stack.removeLast();
                              tempResult = stack.removeLast() / temp;
                              break;
                }
                stack.addLast((int) tempResult);
            }
        }
        return new Integer(stack.removeLast());
    }
}