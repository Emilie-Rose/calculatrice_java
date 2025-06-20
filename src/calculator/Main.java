package calculator;

public class Main {
    public static void main(String[] args) {
        CalculatorModel calc = new CalculatorModel();
        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("5 ^ 3 = " + calc.power(5, 3));
        System.out.println("Factorielle(5) = " + calc.factorial(5));
    }
}
