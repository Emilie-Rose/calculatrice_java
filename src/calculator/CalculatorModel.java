package calculator;

/**
 * Classe qui contient toutes les opérations de base.
 */
public class CalculatorModel {

    // Addition
    public double add(double a, double b) {
        return a + b;
    }

    // Soustraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division (vérification de la division par zéro)
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        return a / b;
    }

    // Modulo
    public double modulo(double a, double b) {
        return a % b;
    }

    // Puissance
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Racine carrée
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Racine carrée d'un nombre négatif");
        }
        return Math.sqrt(a);
    }

    // Factorielle (itérative pour éviter stack overflow)
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorielle d'un nombre négatif");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Valeur absolue
    public double abs(double a) {
        return Math.abs(a);
    }

    // Logarithme base 10
    public double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Logarithme d'un nombre ≤ 0");
        }
        return Math.log10(a);
    }
}
