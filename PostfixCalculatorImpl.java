public class PostfixCalculatorImpl implements PostfixCalculator {
    private IStack<Integer> stack;

    public PostfixCalculatorImpl(IStack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public int evaluate(String expression) throws Exception {

        // Se limpia la pila por si se reutiliza
        stack.clear();

        String[] tokens = expression.trim().split("\\s+");
        for (String token : tokens) {

            // Si es un numero
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            }

            // Si es un operador
            else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new Exception("Operandos insuficientes");
                }

                int b = stack.pop();
                int a = stack.pop();

                int result = applyOperator(a, b, token);
                stack.push(result);
            }

            // Si no es ni numero ni operador
            else {
                throw new Exception("Token invalido: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new Exception("Expresion postfix mal formada");
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") ||
                token.equals("%");
    }

    private int applyOperator(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new Exception("Division entre cero");
                return a / b;
            case "%":
                if (b == 0)
                    throw new Exception("Modulo entre cero");
                return a % b;
            default:
                throw new Exception("Operador invalido: " + operator);
        }
    }
}
