package dataStructures;
import java.util.Scanner;

public class Financial_Forecasting
{
    
    public static double futureValue(int years, double rate, double princ) 
    {
        for (int i = 0; i < years; i++) 
        {
            princ = princ * (1 + rate);
        }
        return princ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter initial investment amount: ");
        double princ = scanner.nextDouble();

        System.out.print("Enter annual growth rate: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        
        double result = futureValue(years, rate, princ);

        
        System.out.printf("Future value after %d years: %.2f\n", years, result);

        scanner.close();
    }
}
