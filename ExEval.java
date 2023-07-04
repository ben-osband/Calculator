/*
 * Ben Osband
 * 6/28/2023
 * ExpressionEvaluator.java
 * 
 */

import java.util.Stack;

public interface ExEval {

    

    public default double evaluate(String expression, String notation) {

        if(notation.equals("in")) {
            return evaluateInfixExpression(expression);
        } else if(notation.equals("pre")) {
            return evaluatePostfixExpression(reverse(expression));
        } else {
            return evaluatePostfixExpression(expression);
        }

    }


    private double evaluatePostfixExpression(String expression) throws ArithmeticException {
        
        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if(isOperand(c)) {
                
                stack.push(Character.toString(c));

            } else if(isOperator(c)) {
                
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());

                stack.push(Double.toString(performBinaryOperation(a, b, c)));

            }

        }

        if(stack.size() == 1) {
            return Double.parseDouble(stack.pop());
        } else {
            throw new ArithmeticException();
        }

    }


    private double evaluateInfixExpression(String expression) throws ArithmeticException {
        
        

    }


    private double performBinaryOperation(double a, double b, char operand) {

        double result = 0;

        switch(operand) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }

        return result;

    }
    

    private String reverse(String str) {
        
        char[] ch = str.toCharArray();
        String result = "";

        for(int i = ch.length-1; i >= 0; i--) {
            result += ch[i];
        }

        return result;

    }


    private boolean isOperand(char c) {

        if(c >= 48 && c <= 57) {
            return true;
        }

        return false;

    }


    private boolean isOperator(char c) {

        if(!(c == '+' || c == '-' || c == '*' || c == '/')) {
            return false;
        }

        return true;

    }

 }