//function or Method
public class FactorialProgram {
    public static void main(String[] args) {
        System.out.println("Factorial = " + calculateFactorial(5));
        System.out.println("Factorial = " + calculateFactorial(4));
    }

    public static int calculateFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
