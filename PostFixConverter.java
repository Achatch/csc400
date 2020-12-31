package csc400;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class PostFixConverter {
    private String infix; // The infix expression to be converted
    private Deque<Character> stack = new ArrayDeque<Character>();
    private List<String> postfix = new ArrayList<String>(); // To hold the postfix expression

    public PostFixConverter(String expressionStart) {
    	String expression = CharFix(expressionStart);
    	System.out.println("Expression resolves to: "+expression); // Show the user their expression
        infix = expression;
        convertExpression();
        }
    String CharFix(String expressionStart) { // Breaks the initial expression into non-whitespaced integers or operators.
    	String expressionSplit[] = expressionStart.split(" ");
    	String expression = "";
    	int size = expressionSplit.length;
        for (int i=0; i<size;i++){
            String endparen = "";
            String splitz = expressionSplit[i];
            if (splitz.indexOf('(') == 0){
                 expression = expression + '(';
                 splitz = splitz.replace("(","");
            }
            if (splitz.indexOf(')') != -1){
                splitz = splitz.replace(")","");
                endparen = ")";
            }
            switch(splitz){
                case "data1":
                    expression = expression + '1'+endparen;
                    break;
                case "data2":
                    expression = expression + '2'+endparen;
                    break;
                case "data3":
                    expression = expression + '4'+endparen;
                    break;
                case "data4":
                    expression = expression + '5'+endparen;
                    break;
                case "data5":
                    expression = expression + '3' +endparen;
                    break;
                case "+":
                    expression = expression + '+';
                    break;
                case "-":
                    expression = expression + '-';
                    break;
                case "*":
                    expression = expression + '*';
                    break;
                case "/":
                    expression = expression + "/";
                    break;
            	} 
        	}
        return expression;
        }
    private void convertExpression(){ // Basically, determine if integer or operator
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i != infix.length(); ++i){           
            if(Character.isDigit(infix.charAt(i))){
                temp.append(infix.charAt(i));

                while((i+1) != infix.length() && (Character.isDigit(infix.charAt(i+1)) || infix.charAt(i+1) == '.')){
                    temp.append(infix.charAt(++i));
                }
                postfix.add(temp.toString());
                temp.delete(0, temp.length());
            }
            // Else operator
            else
                inputToStack(infix.charAt(i));
        }
        clearStack();
    }


    private void inputToStack(char input){ //Push to stack
        if(stack.isEmpty() || input == '(')
            stack.addLast(input);
        else {
            if(input == ')'){
                while(!stack.getLast().equals('(')){ //FILO find paren pairs
                    postfix.add(stack.removeLast().toString());
                }
                stack.removeLast();
            }
            else{
                if(stack.getLast().equals('(')) { //FILO find paren start
                    stack.addLast(input);
                    }
                else{
                    while(!stack.isEmpty() && !stack.getLast().equals('(') && getPrecedence(input) <= getPrecedence(stack.getLast())){
                        postfix.add(stack.removeLast().toString());
                    }
                    stack.addLast(input);
                }
            }
        }
    }


    private int getPrecedence(char op){ //PEMDAS
         if (op == '+' || op == '-')
                return 1;
         else if (op == '*' || op == '/')
                return 2;
         else if (op == '^')
                return 3;
         else return 0;
    }


    private void clearStack(){
        while(!stack.isEmpty()){
            postfix.add(stack.removeLast().toString());
        }
    }

    public List<String> getPostfixAsList(){
        return postfix;
    }
}

