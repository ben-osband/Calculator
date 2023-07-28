/*
 * Ben Osband
 * 7/28/2023
 * ExEval.java
 * Contains methods to evaluate either an infix, prefix, or postfix expression
 */

import java.util.Stack;

public class ExEval {

    /*
     * Calls proper evaluation algorithm depending on notation
     * 
     * @param  expression the expression entered by the user
     * @param  notation   the value of the notation toggle as selected by the user
     * @return            the value of the expression
    */
    public double evaluate(String expression, String notation) {

        if(notation.equals("in")) {
            return evaluateInfixExpression(expression);
        } else if(notation.equals("pre")) {
            return evaluatePostfixExpression(reverse(expression));
        } else {
            return evaluatePostfixExpression(expression);
        }

    }


    /* 
     * Uses a stack to evaluate a postfix expression
     * Iterates over the expression from left to right, pushing operands to the stack
     * When an operator comes up, the top the operands are popped off the stack, processed
     * and the result is pushed back onto the stack
     * The value remaining on the stack is the answer
     * 
     * @param  expression  the expression entered by the user
     * @return             the value of the expression
    */
    private double evaluatePostfixExpression(String expression) throws ArithmeticException {
        
        Stack<Double> stack = new Stack<Double>();

        for(int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if(isOperand(c)) {
                
                stack.push(Double.parseDouble(Character.toString(c)));

            } else if(isOperator(c)) {
                
                double a = stack.pop();
                double b = stack.pop();

                stack.push(performBinaryOperation(a, b, c));

            }

        }

        if(stack.size() == 1) {
            return stack.pop();
        } else {
            throw new ArithmeticException("Error");
        }

    }

    /*
     * Uses two stacks and essentially the same algorithm as postfix evaluation except
     * it accounts for order of operations / precedence of operators
     * @param  expression  the expression entered by the user
     * @return             the value of the expression
    */
    private double evaluateInfixExpression(String expression) throws ArithmeticException {
        
        Stack<Character> operators = new Stack<Character>();
        Stack<Double> operands = new Stack<Double>();

        char[] ch = expression.toCharArray();

        for(int i = 0; i < ch.length; i++) {
            
            char c = ch[i];

            if(isOperand(c)) {
                
                double num = 0;
                
                while (i < ch.length && Character.isDigit(ch[i])) {
                    
                    num = num * 10 + (ch[i] - '0');
                    i++;

                }

                i--;

                operands.push(num);

            } else if(c == '(') {
                
                operators.push(c);

            } else if(c == ')') {
                
                while(operators.peek() != '('){
                    
                    double a = operands.pop();
                    double b = operands.pop();
                    char operator = operators.pop();
                    double ans = performBinaryOperation(a, b, operator);
                    operands.push(ans);

                }

                operators.pop();

            } else if(isOperator(c)) {
                
                while(!operators.empty() && precedence(c) <= precedence(operators.peek())) {
                    
                    double a = operands.pop();
                    double b = operands.pop();
                    char operator = operators.pop();
                    double ans = performBinaryOperation(a, b, operator);
                    operands.push(ans);

                }

                operators.push(c);

            }

        }

        while(!operators.empty()) {
                    
            double a = operands.pop();
            double b = operands.pop();
            char operator = operators.pop();
            double ans = performBinaryOperation(a, b, operator);
            operands.push(ans);
        
        }

        return operands.pop();

    }


    /*
     * Performs a different operation with the two numbers depending on the operator
     * 
     * @param  a  the first number
     * @param  b  the second number
     * @return    the result of performing the operation
    */
    private double performBinaryOperation(double a, double b, char operator) throws ArithmeticException {

        double result = 0;

        switch(operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if(a == 0) {
                    throw new ArithmeticException("Error");
                } else {
                    result = b / a; 
                }
                break;
        }

        return result;

    }
    

    /*
     * Reverses a string
     * 
     * @param  str  the string to be reversed
     * @return      the reversed string
    */
    private String reverse(String str) {
        
        char[] ch = str.toCharArray();
        String result = "";

        for(int i = ch.length-1; i >= 0; i--) {
            result += ch[i];
        }

        return result;

    }


    // returns true if the character is an operand
    private boolean isOperand(char c) {

        if(c >= 48 && c <= 57) {
            return true;
        }

        return false;

    }


    // returns true if the character is an operator
    private boolean isOperator(char c) {

        if(!(c == '+' || c == '-' || c == '*' || c == '/')) {
            return false;
        }

        return true;

    }


    // returns 1 for operators of lower precedence and 2 for ones of higher precedence
    private int precedence(char c) {
        
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;

    }

}