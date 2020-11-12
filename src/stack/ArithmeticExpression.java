package stack;

/**
 * Created by tkmaab4 on 4/11/20.
 * Given an arithmetic expression with *,/,- & + operators and single digit numbers,evaluate it and return the result.
 * Theexpression can also contain parenthesis.
 * For example,1 + 2 / 1 + 3 * 2 ==> 9 1  + (1 + 3) * 2 ==> 101 + 2 / (1 + 3) * 2 ⇒ 1
 */
public class ArithmeticExpression {

    public static void main(String[] args){
        char[] expression = {'1','+','2','/','1','+','3','*','2'};

        int result = evaluateExpression(expression);
        System.out.println("Result >"+ result);

    }

    private static int evaluateExpression(char[] expression) {
        if (expression == null || expression.length == 0){
            return 0;
        }

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (char ch : expression){
            if(isOperand(ch)){
                operand.push(new Node<Integer>(ch-'0'));
            }else if(isOperator(ch)){
                    //while(!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)){
                if (!operator.isEmpty() && precedence(operator.peek()) > precedence(ch)) {
                    process(operand,operator);
                }
                //}
                operator.push(new Node<Character>(ch));

            } else if (ch == '(') {
                operator.push(new Node<Character>(ch));
            }else if (ch ==')'){
               while (operator.peek() != '(') {
                   process(operand,operator);
               }
               operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            process(operand, operator);
        }

        return operand.pop().value;
    }

    private static void process(Stack<Integer> operand, Stack<Character> operator) {
        int num1 = operand.pop().value;
        int num2 = operand.pop().value;
        char op = operator.pop().value;
        int result = 0;
        switch (op) {
            case '+' : result = num1 + num2;
            break;
            case '-' : result = num2 - num1;
            break;
            case '*' : result = num2 * num1;
            break;
            case '/' : result = num2/num1;
            break;
        }
        operand.push(new Node<>(result));

    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*'  || ch == '/';
    }

    private static boolean isOperand(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+' : return 1;
            case '-' : return 1;
            case '*':  return 2;
            case '/':  return 2;
            case '(':  return 0;
            case ')':  return 0;
            default: throw new IllegalArgumentException("Invalid operator " + ch);
        }
    }

}
