import java.util.Scanner;
public class FinForecast {
    public static double futureValue(double principal, double rate, int years) { //using recursion to calcute future value
        if (years == 0) {
            return principal;
        }
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the annual growth rate (as a decimal): ");
        double rate = scanner.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        double result = futureValue(principal, rate, years);
        System.out.printf("Future Value : %.2f\n", result);
    }
}
